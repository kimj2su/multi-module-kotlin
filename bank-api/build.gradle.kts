dependencies {

    implementation(project(":bank-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // slf4j
    implementation("ch.qos.logback:logback-classic:1.4.14")
}