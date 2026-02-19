plugins {
    id("java")
}

group = "com.kyj"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // 롬복 의존성 적용
    implementation("org.projectlombok:lombok:1.18.42")
}

tasks.test {
    useJUnitPlatform()
}