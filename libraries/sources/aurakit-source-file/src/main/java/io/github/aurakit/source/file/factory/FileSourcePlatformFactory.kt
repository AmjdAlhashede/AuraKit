package io.github.aurakit.source.file.factory

import io.github.aurakit.core.factory.sources.AuraSourcePlatformFactory
import io.github.aurakit.core.model.AuraMediaSource
import io.github.aurakit.core.source.AuraSourcePlatform
import io.github.aurakit.source.file.platform.FileSourcePlatform


class FileSourcePlatformFactory(
    private val auraSourcePlatform : AuraSourcePlatform= FileSourcePlatform()
) : AuraSourcePlatformFactory {

    override fun supports(source: AuraMediaSource): Boolean = auraSourcePlatform.supports(source)

    override fun create(): AuraSourcePlatform = auraSourcePlatform

}
