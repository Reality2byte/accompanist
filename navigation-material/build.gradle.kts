/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.accompanist.android.library)
    alias(libs.plugins.accompanist.android.library.compose)
    alias(libs.plugins.accompanist.android.library.published)
}

android {
    namespace = "com.google.accompanist.navigation.material"

    packaging {
        // Some of the META-INF files conflict with coroutines-test. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources {
            excludes += listOf("/META-INF/AL2.0", "/META-INF/LGPL2.1")
        }
    }
}

dependencies {
    api(libs.androidx.navigation.compose)
    implementation(libs.compose.foundation.foundation)
    implementation(libs.compose.material.material)
    implementation(libs.kotlin.coroutines.android)

    // ======================
    // Test dependencies
    // ======================

    androidTestImplementation(project(":internal-testutils"))
    androidTestImplementation(libs.androidx.navigation.testing)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.truth)

    androidTestImplementation(libs.compose.ui.test.junit4)
    androidTestImplementation(libs.compose.ui.test.manifest)
    androidTestImplementation(libs.compose.foundation.foundation)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
}
