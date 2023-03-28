
plugins {
    kotlin("multiplatform") version "1.8.0"
    id("org.openjfx.javafxplugin") version "0.0.10"
    application
}

group = "me.driven"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
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
    
    js(IR) {
        binaries.executable()

    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
                implementation ("org.jetbrains.kotlinx:kotlinx-datetime:0.3.0")
                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
                implementation ("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
                implementation ("org.jetbrains.kotlin:kotlin-reflect")
                implementation ("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
                implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.31")
                implementation ("org.jetbrains.kotlinx:kotlinx-cli:0.3.1")
                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
                implementation ("org.jetbrains.kotlin:kotlin-test-junit:1.5.31")
                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")

                implementation("org.apache.xmlgraphics:batik-transcoder:1.14")
                implementation("org.apache.xmlgraphics:batik-svggen:1.14")
                implementation("org.jfree:jfreesvg:3.3")
                implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
            }
        }
        val jvmTest by getting
        val jsMain by getting{

        }
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}