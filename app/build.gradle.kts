plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.AndroidPdfViewer"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.bellalhossainmondal"
            artifactId = "android-pdfviewer"
            version = "1.1.0"

            pom {
                name.set("Android Pdf Viewer")
                description.set("Description of my library.")
                url.set("https://github.com/bellalhossainmondal/AndroidPdfViewer")

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("bellalhossainmondal")
                        name.set("Bellal Hossain Mondal")
                        email.set("support@bellalhossainmondal.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/bellalhossainmondal/AndroidPdfViewer.git")
                    developerConnection.set("scm:git:ssh://github.com:bellalhossainmondal/AndroidPdfViewer.git")
                    url.set("https://github.com/bellalhossainmondal/AndroidPdfViewer")
                }
            }
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.github.barteksc:pdfium-android:1.9.0")
}