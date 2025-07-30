include(":libraries:aurakit-android-prime")

//aurakit
include(":libraries:aurakit-common")
include(":libraries:aurakit-context-lifecycle")

//cores
include(":libraries:core:aurakit-core")
include(":libraries:core:aurakit-codec-core")
include(":libraries:core:aurakit-source-core")
include(":libraries:core:aurakit-operation-core")


//foundations
include(":libraries:foundation:aurakit-codecs-foundation")
include(":libraries:foundation:aurakit-sources-foundation")

//codecs
include(":libraries:codec:aurakit-codec-ogg")

//operations
include(":libraries:operation:aurakit-media-transcoder")


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

    versionCatalogs {
        create("aurakit") {
            from(files("gradle/aurakit.versions.toml"))
        }
    }
}

rootProject.name = "AuraKit"
include(":app")






//demos
include(":demo:media-convertor-demo")

