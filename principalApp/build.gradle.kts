plugins {
    id("com.android.application")
    kotlin("android") 
    kotlin("kapt") 
}
repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
}
android {
    compileSdkVersion(33)
    lint {
        baseline = file("lint-baseline.xml")
    }
    defaultConfig {
        applicationId = "com.example.principalApp"
        minSdkVersion(22)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
        namespace = "com.example.principalApp"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
