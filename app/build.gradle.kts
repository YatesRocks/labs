plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // -- JUNIT JUPITER -- 
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // -- END JUNIT --

    // Google's Guava. Collections, other assorted libs.
    implementation(libs.guava)

    // Look and Feel -----
    // https://mvnrepository.com/artifact/com.formdev/flatlaf
    implementation("com.formdev:flatlaf:3.4.1")
    // ===================

    // Layout library ----
    // https://mvnrepository.com/artifact/com.miglayout/miglayout-swing
    implementation("com.miglayout:miglayout-swing:11.3")
    // ===================
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        // This was built with OpenJDK-21-Temurin
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "labs.yates.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
