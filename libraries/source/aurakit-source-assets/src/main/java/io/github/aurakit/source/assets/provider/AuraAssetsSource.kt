package io.github.aurakit.source.assets.provider

import android.content.Context
import io.github.aurakit.common.extensions.nameOfPath
import io.github.aurakit.common.media.AuraMimeTypes
import io.github.aurakit.common.util.AssetUtil
import io.github.aurakit.context.lifecycle.api.AuraContext
import io.github.aurakit.source.core.contract.AuraSource
import java.io.InputStream

class AuraAssetsSource(
    private val context: Context? = AuraContext,
) : AuraSource {

    override fun mimeType(model: Any): String {
        return AuraMimeTypes.AUDIO_OPUS.mime
    }

    override fun length(model: Any): Long? {
        return readByteArray(model)?.size?.toLong()
    }

    override fun readByteArray(model: Any): ByteArray? {
        return runCatching { openStream(model)?.readBytes() }.getOrNull()
    }

    override fun readableName(model: Any): String {
        return model.toString().nameOfPath
    }

    override fun isCompatible(model: Any): Boolean {
        val modelString = model.toString()
        return AssetUtil.isAssetPath(modelString)
    }

    override fun openStream(model: Any): InputStream? {
        val relativePath = AssetUtil.extractAssetRelativePath(model.toString())
        return runCatching { context?.assets?.open(relativePath.toString()) }.getOrNull()
    }
}