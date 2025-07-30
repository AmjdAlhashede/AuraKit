package io.github.aurakit_common.extensions

val String.nameOfPath: String
    get() = substringAfterLast("/")

val String.extension: String
    get() = substringAfterLast('.', "")


val String.nameWithoutExtension: String
    get() = substringBeforeLast(".")

