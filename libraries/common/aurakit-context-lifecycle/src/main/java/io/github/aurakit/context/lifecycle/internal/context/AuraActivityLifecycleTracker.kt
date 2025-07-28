package io.github.aurakit.context.lifecycle.internal.context


import android.content.Context

internal object AuraContextHolder {
    internal var appContext: Context? = null

    internal fun initialize(context: Context?) {
        appContext = context?.applicationContext
    }
}
