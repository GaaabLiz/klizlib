plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = project.properties["projectGroup"].toString()
version = project.properties["projectVersion"].toString()

repositories {
    mavenCentral()
    mavenLocal()
    google()
}

kotlin {
    val jvmTarget: String by properties
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = jvmTarget
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("ch.qos.logback:logback-classic:1.4.3")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.junit.jupiter:junit-jupiter:5.8.2")
            }
        }
    }
}
