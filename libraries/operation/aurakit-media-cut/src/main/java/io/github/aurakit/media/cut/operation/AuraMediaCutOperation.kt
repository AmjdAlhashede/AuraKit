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

package io.github.aurakit.media.cut.operation

import io.github.aurakit.codecs.foundation.factory.AuraCodecFactory
import io.github.aurakit.operation.core.contract.AuraBaseOperation
import io.github.aurakit.sources.foundation.factory.AuraSourceFactory

class AuraMediaCutOperation(
    private val input: Any,
    private val startMs: Long,
    private val endMs: Long
) : AuraBaseOperation<ByteArray> {
    override suspend fun execute(): ByteArray {
        val auraSource = AuraSourceFactory.resolve(input)
        val mimeType = auraSource?.mimeType(input)
        val auraCodec = AuraCodecFactory.resolve(mimeType.toString())

        return auraSource?.openStream(input)?.readBytes() ?: ByteArray(10)
    }
}