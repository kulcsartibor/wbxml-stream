plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {

    implementation(libs.xercesImpl)
    implementation(libs.guava)
    implementation(libs.jaxb.api)
    implementation(libs.jaxb.runtime)


    testImplementation(testLibs.testng)
    testImplementation(testLibs.xmlunit)
}

group = "com.xpo.wbxml"
version = "0.5.0"
description = "wbxml-stream"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.named<Test>("test") {
    useTestNG()
}
