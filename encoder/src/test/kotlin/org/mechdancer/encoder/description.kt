package org.mechdancer.encoder

import org.mechdancer.encoder.core.Field
import org.mechdancer.encoder.core.Property
import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    val struct = TypeGraph(mutableMapOf())
    struct.operate {
        this["vector"] = setOf(
            Field("data", "d", Property.Array)
        )
        this["vector2D"] = setOf(
            Field("x", "d", Property.Unit),
            Field("y", "d", Property.Unit)
        )
    }

    test(struct, "vector")
    test(struct, "vector2D")
}

fun test(graph: TypeGraph<*>, type: String) {
    graph
        .serialize(type)
        .also { println(it.joinToString(" ")) }
        .let { TypeGraph.deserialize(ByteArrayInputStream(it)) }
        .forEach { (name, fields) -> println("$name: $fields") }
        .also { println() }
}