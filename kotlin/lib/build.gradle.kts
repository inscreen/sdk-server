version = "0.1.1"

group "com.github.inscreen"

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.inscreen"
            artifactId = "sdkserver"
            version = "0.0.0" // Doesn't apply.

            from(components["java"])
        }
    }
}
