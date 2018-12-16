package org.mechdancer.remote.modules.group

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.dependency.unique.UniqueDependencyManager
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Group
import org.mechdancer.remote.resources.UdpCmd

/**
 * 组成员的管理器
 *   发现新成员时会自动调用函数 [detected]
 *   从未出现过的成员或离线时间超过超时时间 [timeout] 的成员出现时视作新成员
 */
class GroupMonitor(
    private val detected: (String) -> Unit = {},
    private val timeout: Int = Int.MAX_VALUE
) : UniqueComponent<GroupMonitor>(), Dependent, MulticastListener {

    private val manager = UniqueDependencyManager()

    private val update by manager.must { it: Group -> it::detect }
    private val broadcaster by manager.maybe<MulticastBroadcaster>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    /** 请求组中的成员响应，以证实存在性，要使用此功能必须依赖组播发送 */
    fun yell() = broadcaster!!.broadcast(UdpCmd.YELL_ASK)

    override val interest = INTEREST

    override fun process(remotePacket: RemotePacket) {
        val (name, cmd) = remotePacket

        if (name.isNotBlank()) // 只保存非匿名对象
            update(name)
                ?.takeUnless { System.currentTimeMillis() - it > timeout }
                ?: detected(name)

        if (cmd == UdpCmd.YELL_ASK.id) // 回应询问
            broadcaster?.broadcast(UdpCmd.YELL_ACK)
    }

    private companion object {
        val INTEREST = setOf<Byte>()
    }
}
