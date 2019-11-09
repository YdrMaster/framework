---
title: org.mechdancer.remote.protocol.java.io.OutputStream - framework
---

[framework](../../index.html) / [org.mechdancer.remote.protocol](../index.html) / [java.io.OutputStream](./index.html)

### Extensions for java.io.OutputStream

| [writeEnd](write-end.html) | 向流写入 [string](write-end.html#org.mechdancer.remote.protocol$writeEnd(java.io.OutputStream, kotlin.String)/string)，再写入结尾`fun `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`.writeEnd(string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html) |
| [writeWithLength](write-with-length.html) | 先将长度写入流，再将 [pack](write-with-length.html#org.mechdancer.remote.protocol$writeWithLength(java.io.OutputStream, kotlin.ByteArray)/pack) 写入流`infix fun `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`.writeWithLength(pack: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
