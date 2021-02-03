dependencies {
    // libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)

    implementation(Config.Libs.Kotlin.coroutinesCore)
    implementation(Config.Libs.Mics.jsoup)
    // modules
    api(project(":core"))
    // api(project(":network"))
}
