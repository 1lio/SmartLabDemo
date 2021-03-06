dependencies {

    // Libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)
    implementation(Config.Libs.Androidx.vectorAnimation)
    implementation(Config.Libs.Androidx.constraint)

    implementation(Config.Libs.Kotlin.coroutinesCore)
    implementation(Config.Libs.Kotlin.coroutinesAndroid)

    implementation(Config.Libs.Androidx.navigationFragment)
    implementation(Config.Libs.Androidx.navigationUI)

    implementation(Config.Libs.Mics.jsoup)

    implementation(Config.Libs.Mics.picasso)

    // modules
    api(project(":core"))
    api(project(":network"))
    api(project(":repo"))
}