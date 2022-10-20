group = "com.inscreen"
version = "0.1.1" // Update below too

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    `java-library`
    `signing`
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

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.inscreen"
            artifactId = "sdkserver"
            version = "0.1.1" // Update above too

            pom {
                name.set("inScreen server-side SDK")
                description.set("An SDK for using inScreen for Java/Kotlin applications")
                url.set("https://inscreen.com/")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/mit-license.php")
                    }
                }
                developers {
                    developer {
                        name.set("inScreen")
                        email.set("info@inscreen.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/inscreen/sdk-server.git")
                    developerConnection.set("scm:git:ssh://github.com/inscreen/sdk-server.git")
                    url.set("https://github.com/inscreen/sdk-server/")
                }
            }

            from(components["java"])
        }

        repositories {
            maven {
                name = "OSSRH"
                setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = System.getenv("MAVEN_USERNAME")
                    password = System.getenv("MAVEN_PASSWORD")
                }
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(System.getenv("MAVEN_GPG_KEY"), System.getenv("MAVEN_GPG_PASSPHRASE"))
    sign(publishing.publications)
}
