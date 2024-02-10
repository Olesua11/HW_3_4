plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")


}

android {
    namespace = "com.example.hw_3_4"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hw_3_4"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }


    dependencies {
        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.11.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        implementation("androidx.viewpager2:viewpager2:1.0.0")
        implementation("androidx.viewpager2:viewpager2:1.0.0")
        implementation ("com.github.bumptech.glide:glide:4.12.0")
        annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
        implementation( "androidx.fragment:fragment:1.3.0")
        implementation ("androidx.fragment:fragment-ktx:1.3.0")
        implementation ("me.relex:circleindicator:2.1.6 ")
        implementation ("me.relex:circleindicator:2.1.6")
        val room_version = "2.6.1"
        implementation ("androidx.room:room-ktx:2.6.1")

        implementation("androidx.room:room-runtime:$room_version")
        ksp("androidx.room:room-compiler:$room_version")

        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
        implementation ("com.google.code.gson:gson:2.8.9")

        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
        implementation  (platform ("com.google.firebase:firebase-bom:32.7.1"))
        implementation  ("com.google.firebase:firebase-auth")

        implementation ("com.google.android.gms:play-services-auth:20.7.0")
        implementation ("studio.clapp:wheelpicker:1.0.1")







    }
}
