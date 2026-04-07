plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "workshop"
version = "1.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("workshop.MainKt")
}

kotlin {
    jvmToolchain(24)
}
