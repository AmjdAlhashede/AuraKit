package io.github.aurakit.context.lifecycle.api

import android.content.Context
import io.github.aurakit.context.lifecycle.internal.context.AuraContextHolder

val AuraContext: Context?
        get() = AuraContextHolder.appContext