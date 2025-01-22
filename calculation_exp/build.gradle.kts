import io.netty.util.ReferenceCountUtil.release
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.example.calculation_exp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.appcompat.v7)
    testImplementation(libs.junit)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.espresso.core)
}

val githubProperties = Properties().apply {
    load(FileInputStream(rootProject.file("github.properties")))
}
/*publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "io.calcy.libraries" // Replace with your desired group ID
            artifactId = "calculation_exp"  // Replace with your desired artifact ID
            version = "1.0.0"              // Replace with your desired version

            // Include the generated AAR file
            afterEvaluate {
                from(components["release"])
            }
        }
    }
*//*
    repositories {
        maven {
            name = "GitHubPackages"

            url = uri("https://maven.pkg.github.com/FsnDevil/calculation_exp")
            credentials {
                username = (githubProperties["gpr.usr"] ?: System.getenv("GPR_USER")).toString()
                password = (githubProperties["gpr.key"] ?: System.getenv("GPR_API_KEY")).toString()
            }
        }
    }*//*
}*/

afterEvaluate {
    publishing{
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "io.calcy.libraries" // Replace with your desired group ID
                artifactId = "calculation_exp"  // Replace with your desired artifact ID
                version = "1.0.0"              // Replace with your desired version
            }
        }
    }
}