plugins {
    kotlin("jvm") version "2.0.21" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "application")

    group = "workshop"
    version = "1.0"

    repositories {
        mavenCentral()
    }

    configure<JavaApplication> {
        mainClass.set("workshop.MainKt")
    }

    configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
        jvmToolchain(21)
    }
}
