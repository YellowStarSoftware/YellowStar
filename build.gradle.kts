plugins {
    kotlin("jvm") version "2.0.0"
    java
    `maven-publish`
}

version = "0.0.20"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

publishing {
    publications {
        register("YellowStar", MavenPublication::class) {
            groupId = "yellow-star-software"
            artifactId = "yellow-star"
            from(components["java"])
        }
    }
    repositories {
        val localRepoPath = project.property("localMavenRepositoryPath")
        if (localRepoPath is String) {
            maven {
                name = "localFileRepository"
                url = uri(localRepoPath)
            }
        }
    }
}