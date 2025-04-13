plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin Standard Library
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring Boot Core
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // MongoDB with KMongo
    implementation("org.litote.kmongo:kmongo:4.9.0")

    // Unit Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}