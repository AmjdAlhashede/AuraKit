plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
        Defines the foundational structure for all supported operations in AuraKit, such as media conversion, trimming, and more.
    Serves as the base layer from which concrete operation modules are derived, ensuring consistency and extensibility across the framework.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))

android {
    namespace = "io.github.aurakit.operation.core"

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