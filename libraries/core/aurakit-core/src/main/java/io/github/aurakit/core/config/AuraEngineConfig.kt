package io.github.aurakit.core.config

// AuraEngineConfig.kt
data class AuraEngineConfig(
    val debugMode: Boolean = false,
    val defaultCodec: String? = null,
    val allowExperimental: Boolean = false
)
