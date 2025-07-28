package io.github.aurakit.media.cut

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