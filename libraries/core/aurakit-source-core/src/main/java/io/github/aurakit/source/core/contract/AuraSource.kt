package io.github.aurakit.source.core.contract

import java.io.InputStream

interface AuraSource {
    fun mimeType(model: Any): String
    fun length(model: Any): Long?
    fun readByteArray(model: Any): ByteArray?
    fun readableName(model: Any): String
    fun isCompatible(model: Any): Boolean
    fun openStream(model: Any): InputStream?
}