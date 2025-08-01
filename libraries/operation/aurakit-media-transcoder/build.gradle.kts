plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

description = """
    Feature module in AuraKit that adds media transcoding support.
    Enables conversion between audio and video formats as part of the framework’s modular media toolkit.
""".trimIndent()

apply(from = rootProject.file("common_library_config.gradle"))
apply(from = rootProject.file("aurakit-publish.gradle"))


android {
    namespace = "io.github.aurakit_media_transcoder"

    defaultConfig {
        minSdk = 21

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
    implementation(project(":libraries:foundation:aurakit-sources-foundation"))
    implementation(project(":libraries:foundation:aurakit-codecs-foundation"))

    implementation(aurakit.operation.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}