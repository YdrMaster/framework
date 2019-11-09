---
title: ConnectionListener - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.tcpconnection](../index.html) / [ConnectionListener](./index.html)

# ConnectionListener

`interface ConnectionListener : `[`Component`](../../org.mechdancer.dependency/-component/index.html)

短连接监听者

### Properties

| [interest](interest.html) | `abstract val interest: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html) |

### Functions

| [process](process.html) | `abstract fun process(client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, socket: `[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
