
rootProject.name = "klizlib"

pluginManagement {
    val kotlinVersion: String by settings

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        id("org.jetbrains.kotlin.multiplatform") version kotlinVersion
    }
}