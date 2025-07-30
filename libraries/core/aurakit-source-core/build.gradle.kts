plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
        Defines the abstract source interfaces and contracts that shape the structure of supported media sources in AuraKit.
     Establishes the standardized architecture for implementing custom source modules by outlining common behaviors, capabilities, and interaction patterns.
     Enables consistent integration across the framework by enforcing a clear separation between source definitions and their actual implementations.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))

android {
    namespace = "io.github.aurakit.source.core"
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