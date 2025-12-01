plugins {
    kotlin("jvm") version "2.2.21"
}

group = "bagguley.aoc2025"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(23)
}