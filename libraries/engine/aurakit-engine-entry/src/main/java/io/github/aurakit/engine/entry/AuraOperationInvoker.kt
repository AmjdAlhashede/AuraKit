package io.github.aurakit.engine.entry

import io.github.aurakit.operation.core.contract.AuraBaseOperation

object AuraOperationInvoker {

    suspend fun <T> invoke(operation: AuraBaseOperation<T>): T {
        return operation.execute()
    }
}
