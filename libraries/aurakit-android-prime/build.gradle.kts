plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
       Prime entrypoint to AuraKit's Android ecosystem.
    Offers a unified interface for media handling, asset workflows, and core system access.
    Tailored for direct app integration with emphasis on clarity, modularity, and performance.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))

android {
    namespace = "io.github.aurakit_android_prime"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(aurakit.common)
    api(aurakit.operation.core)
    implementation(project(":libraries:foundation:aurakit-sources-foundation"))
    implementation(project(":libraries:foundation:aurakit-codecs-foundation"))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}