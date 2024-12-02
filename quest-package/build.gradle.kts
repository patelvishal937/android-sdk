plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.example.quest_package"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

}

dependencies {
    testImplementation("junit:junit:4.12")
    // kotlin depedancy
    val composeBom = platform("androidx.compose:compose-bom:2024.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // compose dependacncy
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("quest-package") {
                from(components["release"])
                groupId = "com.github.patelvishal937"
                artifactId = "quest-package"
                version = "1.0"
            }
        }

        repositories {
            maven {
                name = "AndroidLibrary"
                url = uri("https://your-private-repo-url/repository/maven-releases/") // Replace with your private repository URL
                credentials {
                    username = project.findProperty("repo.user") as String? ?: System.getenv("REPO_USER")
                    password = project.findProperty("repo.password") as String? ?: System.getenv("REPO_PASSWORD")
                }
            }
        }
    }
}


