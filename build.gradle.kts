import com.android.build.gradle.internal.cxx.ninja.assignTargetName

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.nexus.publish.plugin)
}

group = aurakit.versions.groupId.get()
version = aurakit.versions.aurakitDevelopmentVersion.get()

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://ossrh-staging-api.central.sonatype.com/service/local/"))
            snapshotRepositoryUrl.set(uri("https://central.sonatype.com/repository/maven-snapshots/"))
            username.set(project.findProperty("ossrhUsername") as String?)
            password.set(project.findProperty("ossrhPassword") as String?)
        }
    }
}
