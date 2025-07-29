plugins {
    id("java-platform")
}

configure<JavaPlatformExtension> {
    allowDependencies()
}

dependencies {
    val aurakitVersion = libs.versions.aurakitVersion.get()
    val groupId = libs.versions.groupId.get()
    constraints {
        api("$groupId:aurakit-core:$aurakitVersion")
        api("$groupId:aurakit-source-core:$aurakitVersion")
        api("$groupId:aurakit-codec-core:$aurakitVersion")
        api("$groupId:aurakit-operation-core:$aurakitVersion")
        api("$groupId:aurakit-sources-foundation:$aurakitVersion")
        api("$groupId:aurakit-codecs-foundation:$aurakitVersion")
        api("$groupId:aurakit-engine-entry:$aurakitVersion")
        api("$groupId:aurakit-context-lifecycle:$aurakitVersion")
        api("$groupId:aurakit-common:$aurakitVersion")
    }
}


apply(from = rootProject.file("aurakit-publish.gradle"))