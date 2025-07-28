package io.github.aurakit.codecs.foundation.factory


import io.github.aurakit.codec.core.contract.AuraCodec
import java.util.ServiceLoader

object AuraCodecFactory {
    private val resolvers = ServiceLoader.load(AuraCodec::class.java).toList()

    fun resolve(mimeType: String): AuraCodec? {
        return resolvers.firstOrNull { it.isCompatible(mimeType) }
    }
}