plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.dependency.management)
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":java"))
    implementation(libs.bundles.spring.boot.base)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
