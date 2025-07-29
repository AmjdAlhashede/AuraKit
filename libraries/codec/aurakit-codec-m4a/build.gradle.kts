plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    signing
}

apply(from = rootProject.file("common_library_config.gradle"))

android {
    namespace = "io.github.aurakit.codec.m4a"
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