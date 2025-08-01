plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
        Core module in AuraKit that defines and organizes the set of supported media sources.
     Serves as the foundation for discovering which types of sources can be handled by the framework, including embedded sources like assets and external ones such as file systems or remote modules.
     Provides a unified interface for resolving and standardizing access to all supported source types.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))

android {
    namespace = "io.github.aurakit.sources.foundation"
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
    api(aurakit.common)
    api(aurakit.context.lifecycle)
    api(aurakit.source.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}