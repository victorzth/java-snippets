plugins {
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    api(libs.bundles.apache.commons)
    api(libs.logback)
    testImplementation(libs.junit5)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
