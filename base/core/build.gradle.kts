dependencies {
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.material)
    implementation(Config.Libs.Androidx.core)

    // Hilt
    implementation(Config.Libs.Androidx.hiltAndroid)
    kapt(Config.Libs.Androidx.hiltCompiler)
}
