@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.fusedlibrary)
}

androidFusedLibrary {
    namespace = "io.github.amjdalhashede.aurakit.engine.entry"
    minSdk = libs.versions.minSdk.get().toInt()
    version = libs.versions.aurakitVersion.get()
    aarMetadata {
        minCompileSdk = libs.versions.compileSdk.get().toInt()
        minCompileSdkExtension = 1
    }
}

dependencies {
    include(project(":libraries:engine:aurakit-engine-entry"))
    include(project(":libraries:common:aurakit-context-lifecycle"))
    include(project(":libraries:core:aurakit-source-core"))
    include(project(":libraries:foundation:aurakit-sources-foundation"))
    include(project(":libraries:source:aurakit-source-assets"))
    include(project(":libraries:core:aurakit-operation-core"))
}

apply(from = rootProject.file("aurakit-publish.gradle"))