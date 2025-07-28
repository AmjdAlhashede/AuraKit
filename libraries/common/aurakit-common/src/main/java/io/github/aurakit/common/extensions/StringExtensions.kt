package io.github.aurakit.common.extensions

val String.nameOfPath: String
    get() = substringAfterLast("/")

val String.extension: String
    get() = substringAfterLast('.', "")


val String.nameWithoutExtension: String
    get() = substringBeforeLast(".")

