/*
 *   Copyright 2025 Amjd Alhashede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.github.builtin.aurakit_source_assets

import android.content.Context
//import io.github.aurakit.common.extensions.nameOfPath
//import io.github.aurakit.common.media.AuraMimeTypes
//import io.github.aurakit.common.util.AssetUtil
//import io.github.aurakit.context.lifecycle.api.AuraContext
//import io.github.aurakit.source.core.contract.AuraSource
import java.io.InputStream

//class AuraAssetsSource(
//    private val context: Context? = AuraContext,
//) : AuraSource {
//
//    override fun mimeType(model: Any): String {
//        return AuraMimeTypes.AUDIO_OPUS.mime
//    }
//
//    override fun length(model: Any): Long? {
//        return readByteArray(model)?.size?.toLong()
//    }
//
//    override fun readByteArray(model: Any): ByteArray? {
//        return runCatching { openStream(model)?.readBytes() }.getOrNull()
//    }
//
//    override fun readableName(model: Any): String {
//        return model.toString().nameOfPath
//    }
//
//    override fun isCompatible(model: Any): Boolean {
//        val modelString = model.toString()
//        return AssetUtil.isAssetPath(modelString)
//    }
//
//    override fun openStream(model: Any): InputStream? {
//        val relativePath = AssetUtil.extractAssetRelativePath(model.toString())
//        return runCatching { context?.assets?.open(relativePath.toString()) }.getOrNull()
//    }
//}