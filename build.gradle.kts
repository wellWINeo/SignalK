plugins {
    kotlin("multiplatform") version "1.7.10"
}

group = "su.uspenskiy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Reaktive
                implementation("com.badoo.reaktive:reaktive:1.2.2")
                implementation("com.badoo.reaktive:reaktive-annotations:1.2.2")
                implementation("com.badoo.reaktive:coroutines-interop:1.2.2") // For interop with coroutines
                //implementation("com.badoo.reaktive:rxjava2-interop:1.2.2") // For interop with RxJava v2
                //implementation("com.badoo.reaktive:rxjava3-interop:1.2.2") // For interop with RxJava v3

                // Ktor
                implementation("io.ktor:ktor-client-core:2.1.2")
                implementation("io.ktor:ktor-client-cio:2.1.2")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                // kotlinx.serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

                // Use the Kotlin test library.
                //testImplementation("org.jetbrains.kotlin:kotlin-test")

                // Use the Kotlin JUnit integration.
                //testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}
