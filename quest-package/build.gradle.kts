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
        languageVersion = "1.7" // Set the Kotlin language version
        apiVersion = "1.7" // Specify the API version
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

}

dependencies {
//    implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
//    implementation("androidx.appcompat:appcompat:1.7.0")
//    testImplementation("junit:junit:4.12")
//    // kotlin depedancy
//    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
//    implementation(composeBom)
//    androidTestImplementation(composeBom)
//    implementation("androidx.compose.material3:material3")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//    implementation("io.coil-kt:coil-compose:2.4.0")
//
////    implementation "androidx.activity:activity-compose:1.6.0"
////    implementation "androidx.lifecycle:lifecycle-runtime-compose:2.6.0"
//    //for api calling use retrofit
//
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // compose dependacncy


    //new dependancy

// Compose BOM for dependency alignment
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))

// Compose core libraries
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

// Lifecycle support for Compose
    implementation("androidx.activity:activity-compose:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

// Coil for image loading in Compose
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



// Development utilities
    debugImplementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}


//afterEvaluate {
//    publishing {
//        publications {
//            create<MavenPublication>("quest-package") {
//                from(components["release"])
//                groupId = "com.github.patelvishal937"
//                artifactId = "quest-package"
//                version = "1.0"
//            }
//        }
//
//        repositories {
//            maven {
//                name = "AndroidLibrary"
//                url = uri("https://your-private-repo-url/repository/maven-releases/") // Replace with your private repository URL
//                credentials {
//                    username = project.findProperty("repo.user") as String? ?: System.getenv("REPO_USER")
//                    password = project.findProperty("repo.password") as String? ?: System.getenv("REPO_PASSWORD")
//                }
//            }
//        }
//    }
//}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.questlabs"
            artifactId = "quest-android-sdk"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
    repositories {
        maven {
            name = "quest-android-sdk-repo"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

tasks.register("publishToLocal") {
    group = "publishing"
    description = "Builds the library and publishes it to the local Maven repository."

    dependsOn("assembleRelease", "publish")

    doLast {
        println("Library successfully published to the local Maven repository at: ${rootProject.buildDir}/repo")
    }
}

