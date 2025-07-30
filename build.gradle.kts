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


tasks.register("syncAndPublishAuraKit") {
    group = "AuraKit"
    description = "Sync TOML version and publish AuraKit locally"

    outputs.upToDateWhen { false }

    dependsOn("publishToMavenLocal") // يجب أن يكون خارج doLast

    doLast {
        val tomlFile = file("gradle/aurakit.versions.toml")
        val content = tomlFile.readText()

        val devVersion = Regex("""aurakitDevelopmentVersion\s*=\s*"([^"]+)"""")
            .find(content)?.groups?.get(1)?.value
            ?: throw GradleException("aurakitDevelopmentVersion not found.")

        println("🌀 Development version detected: $devVersion")

        val updatedContent = content.replace(
            Regex("""aurakitPublishedVersion\s*=\s*"([^"]+)""""),
            """aurakitPublishedVersion = "$devVersion""""
        )

        tomlFile.writeText(updatedContent)
        println("✅ Published version updated to: $devVersion")

        println("🔁 Refreshing dependencies...")
//        exec {
//            commandLine("cmd", "/c", "gradlew", "--refresh-dependencies")
//        }

        // Uncomment if ready for Sonatype push
        /*
        println("📦 Publishing to Sonatype...")
        exec {
            commandLine("cmd", "/c", "gradlew", "publishToSonatype", "closeAndReleaseSonatypeStagingRepository")
        }
        */
    }
}

