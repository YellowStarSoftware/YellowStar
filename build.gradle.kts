plugins {
    kotlin("jvm") version "2.0.0"
    java
    `java-library`
}

group = "YellowStarSoftware"
version = "0.0.17"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}