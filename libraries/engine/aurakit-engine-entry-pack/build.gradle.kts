@file:Suppress("UnstableApiUsage")


plugins {
    alias(libs.plugins.android.fusedlibrary)
    `maven-publish`
}

androidFusedLibrary {
    namespace = "io.github.amjdalhashede.aurakit.engine.entry"
    minSdk = libs.versions.minSdk.get().toInt()
    version = aurakit.versions.aurakitVersion.get()

    aarMetadata {
        minCompileSdk = libs.versions.minSdk.get().toInt()
        minCompileSdkExtension = 1
    }
}

dependencies {
    include(project(":libraries:common:aurakit-common"))
    include(project(":libraries:engine:aurakit-engine-entry"))
    include(project(":libraries:common:aurakit-context-lifecycle"))
    include(project(":libraries:core:aurakit-source-core"))
    include(project(":libraries:foundation:aurakit-sources-foundation"))
    include(project(":libraries:core:aurakit-operation-core"))
}

apply(from = rootProject.file("aurakit-fused-publish.gradle"))