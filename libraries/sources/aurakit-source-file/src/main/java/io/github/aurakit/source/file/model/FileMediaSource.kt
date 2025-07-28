package io.github.aurakit.source.file.model

import io.github.aurakit.core.model.AuraMediaSource
import java.io.File

data class FileMediaSource(val file: File) : AuraMediaSource {
    override val path: String = file.absolutePath
}
