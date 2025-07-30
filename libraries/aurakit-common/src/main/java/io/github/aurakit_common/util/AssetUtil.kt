package io.github.aurakit_common.util

import io.github.aurakit_common.ASSETS_FILE_PATH
import io.github.aurakit_common.ASSETS_FILE_URI


object AssetUtil {

    fun normalizeAssetPath(input: String): String {
        return when {
            input.startsWith(ASSETS_FILE_URI) -> input
            input.startsWith(ASSETS_FILE_PATH) -> input.replaceFirst(
                ASSETS_FILE_PATH,
                ASSETS_FILE_URI
            )
            else -> input
        }
    }

    fun isAssetPath(input: String): Boolean {
        return input.startsWith(ASSETS_FILE_PATH) || input.startsWith(ASSETS_FILE_URI)
    }

    fun extractAssetRelativePath(input: String): String? {
        return when {
            input.startsWith(ASSETS_FILE_URI) -> input.removePrefix(ASSETS_FILE_URI)
            input.startsWith(ASSETS_FILE_PATH) -> input.removePrefix(ASSETS_FILE_PATH)
            else -> null
        }
    }
}
