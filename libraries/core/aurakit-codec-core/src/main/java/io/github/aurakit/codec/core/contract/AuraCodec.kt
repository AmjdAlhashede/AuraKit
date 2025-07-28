package io.github.aurakit.codec.core.contract

interface AuraCodec {
    fun isCompatible(mimeType: String): Boolean
    fun decode(data: ByteArray): Any
    fun encode(model: Any): ByteArray
}
