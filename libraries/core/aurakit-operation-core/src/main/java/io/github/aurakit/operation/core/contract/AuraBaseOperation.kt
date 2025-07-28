package io.github.aurakit.operation.core.contract

interface AuraBaseOperation<Output> {
    suspend fun execute(): Output
}




