import sun.jvmstat.monitor.MonitoredVmUtil.mainClass

plugins {
    kotlin("jvm") version "2.3.0"
    application
}

group = "org.test"
version = "1.0-SNAPSHOT"

val lwjglVersion = "3.4.1"
val lwjglNatives = "natives-windows"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-vulkan")
    implementation ("org.lwjgl", "lwjgl", classifier = lwjglNatives)
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("org.test.MainKt")
}

tasks.test {
    useJUnitPlatform()
}