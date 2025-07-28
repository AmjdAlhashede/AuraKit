package io.github.aurakit.engine


import io.github.aurakit.core.operation.AuraMediaOperation
import io.github.aurakit.core.registry.AuraOperationFactoryRegistry

object AuraKit {

    fun process(
        operation: AuraMediaOperation
    ){
       AuraOperationFactoryRegistry.findSuitableFactory(operation)?.let { factory->
           val executor = factory.create(operation)
           val result = executor.execute()
           println("Output saved to: ${result.outputPath}")
       }
    }
}
