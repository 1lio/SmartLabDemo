android {
    defaultConfig {
        applicationId = Config.applicationID

        versionCode = Config.appVersionCode
        versionName = Config.appVersionName
    }
}

dependencies {

    // Libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)
    implementation(Config.Libs.Androidx.vectorAnimation)
    implementation(Config.Libs.Androidx.constraint)
    implementation(Config.Libs.Androidx.constraint)
    implementation(Config.Libs.Androidx.navigationUI)
    implementation(Config.Libs.Androidx.navigationFragment)

    // Tests
    testImplementation(Config.Libs.Test.junit)
    androidTestImplementation(Config.Libs.Test.junitExt)
    androidTestImplementation(Config.Libs.Test.testJunitKtx)
    androidTestImplementation(Config.Libs.Test.testRunner)
    androidTestImplementation(Config.Libs.Test.testRules)
    androidTestImplementation(Config.Libs.Test.testMonitor)
    androidTestImplementation(Config.Libs.Test.espresso)
    androidTestImplementation(Config.Libs.Test.espressoIntents)

    // modules
   // implementation(project(":navigation"))

   // implementation(project(":account"))
   // implementation(project(":chat"))
   // implementation(project(":feed"))
   // implementation(project(":splash"))
   // implementation(project(":marketmap"))
}