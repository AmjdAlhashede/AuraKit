@file:Suppress("UnstableApiUsage")

include(":libraries:aurakit-bom")


include(":libraries:codec:aurakit-codec-m4a")


include(":libraries:source:aurakit-file-source")
include(":libraries:common:aurakit-context-lifecycle")
include(":libraries:core:aurakit-source-core")
include(":libraries:core:aurakit-codec-core")
include(":libraries:core:aurakit-operation-core")
include(":libraries:common:aurakit-common")
include(":libraries:source:aurakit-source-assets")
include(":libraries:codec:aurakit-codec-mp3")
include(":libraries:codec:aurakit-codec-ogg")
include(":libraries:operation:aurakit-audio-convert")
include(":libraries:operation:aurakit-media-cut")
include(":libraries:foundation:aurakit-sources-foundation")
include(":libraries:foundation:aurakit-codecs-foundation")
include(":libraries:engine:aurakit-engine-entry")
include(":libraries:engine:aurakit-engine-entry-pack")
include(":libraries:core:aurakit-core")



pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "AuraKit"
include(":app")