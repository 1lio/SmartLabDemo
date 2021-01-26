dependencies {

    // Libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)
    implementation(Config.Libs.Androidx.vectorAnimation)
    implementation(Config.Libs.Androidx.constraint)

    implementation(Config.Libs.Kotlin.coroutinesCore)
    implementation(Config.Libs.Kotlin.coroutinesAndroid)

    implementation(Config.Libs.Mics.jsoup)

    // modules
    api(project(":core"))
}