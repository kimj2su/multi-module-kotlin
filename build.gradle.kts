plugins {
	id("org.springframework.boot") version "3.5.3" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false // apply false 적용시에만 사용
	kotlin("jvm") version "2.0.21" apply false
	kotlin("plugin.spring") version "2.0.21" apply false
	kotlin("plugin.jpa") version "2.0.21" apply false

}


allprojects{
	group = "com.jisu"
	version = "0.0.1-SNAPSHOT"
	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "io.spring.dependency-management")

	if(name == "bank-api") {
		apply(plugin = "org.springframework.boot")
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
		apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	}

	if (name == "bank-core") {
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	}

	if (name == "bank-domain") {
		apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}
	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}



