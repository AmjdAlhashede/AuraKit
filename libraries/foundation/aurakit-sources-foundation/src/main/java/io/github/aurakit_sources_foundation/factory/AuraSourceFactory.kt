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

package io.github.aurakit_sources_foundation.factory

import io.github.aurakit_source_core.contract.AuraSource
import java.util.ServiceLoader

object AuraSourceFactory {
    private val resolvers = ServiceLoader.load(AuraSource::class.java).toList()

    fun resolve(model: Any): AuraSource? {
        return resolvers.firstOrNull { it.isCompatible(model) }
    }
}