package io.github.aurakit.sources.foundation.factory

import io.github.aurakit.source.core.contract.AuraSource
import java.util.ServiceLoader

object AuraSourceFactory {
    private val resolvers = ServiceLoader.load(AuraSource::class.java).toList()

    fun resolve(model: Any): AuraSource? {
        return resolvers.firstOrNull { it.isCompatible(model) }
    }
}