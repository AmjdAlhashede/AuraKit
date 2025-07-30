plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
        Serves as the root layer for shared abstractions and components used across multiple feature domains in AuraKit.
    Hosts fundamental contracts and utilities that unify the structural foundations of modules such as sources, codecs, and operations.
    Designed to promote consistency and reusability by centralizing cross-domain definitions at the highest architectural level.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))


android {
    namespace = "io.github.aurakit.core"
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}