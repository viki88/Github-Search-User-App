import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.vikination.githubsearchuserapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.vikination.githubsearchuserapp"
        minSdk = 24
        targetSdk = 35
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
        compose = true
    }
}

kover {
    useJacoco()
    reports{
        filters {
            includes {
                packages(
                    "com.vikination.githubsearchuserapp.data.repository",
//                        "com.vikination.githubsearchuserapp.data.source.local.dao.*",
//                        "com.vikination.githubsearchuserapp.data.source.remote.*",
//                        "com.vikination.githubsearchuserapp.domain.repository.*",
//                        "com.vikination.githubsearchuserapp.presentation.ui.screens.*",
//                        "com.vikination.githubsearchuserapp.presentation.ui.components.*",
//                        "com.vikination.githubsearchuserapp.presentation.ui.theme.*",
                    "com.vikination.githubsearchuserapp.ui.viewmodels"
                )
            }
        }
    }
}

dependencies {
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.prod)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation)
    implementation(libs.kotlinx.serialization)
    implementation(libs.io.insertkoin)
    implementation(libs.dagger.hilt)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.moshi.kotlin)
    implementation(libs.glide)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.shimmer)
    implementation(libs.splashscreen)
    ksp(libs.dagger.hilt.compiler)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.turbine)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.kotlin.coroutine.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}