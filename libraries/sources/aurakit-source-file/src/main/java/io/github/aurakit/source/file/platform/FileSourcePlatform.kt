package io.github.aurakit.source.file.platform


import io.github.aurakit.core.model.AuraMediaFormat
import io.github.aurakit.core.model.AuraMediaMetadata
import io.github.aurakit.core.model.AuraMediaSource
import io.github.aurakit.core.source.AuraSourcePlatform
import java.io.File

class FileSourcePlatform : AuraSourcePlatform {

    override fun supports(source: AuraMediaSource): Boolean =
        source.path.startsWith("/") && File(source.path).exists()

    override fun read(source: AuraMediaSource): ByteArray =
        File(source.path).readBytes()

    override fun save(source: AuraMediaSource, bytes: ByteArray): Boolean =
        try {
            File(source.path).writeBytes(bytes)
            true
        } catch (e: Exception) {
            false
        }

    override fun extractFormat(source: AuraMediaSource): AuraMediaFormat? {
        val mime = when {
            source.path.endsWith(".mp3", true) -> "audio/mpeg"
            source.path.endsWith(".wav", true) -> "audio/wav"
            else -> return null
        }

        return object : AuraMediaFormat {
            override val mimeType: String = mime
        }
    }

    override fun extractMetadata(source: AuraMediaSource): AuraMediaMetadata? =
        AuraMediaMetadata(
            durationMs = 125000,
            channels = 2,
            sampleRate = 44100
        )
}
