dependencies {
    // libs
    implementation(Config.Libs.Kotlin.coroutinesCore)

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)

    // Network
    implementation(Config.Libs.Network.retrofit2)
    implementation(Config.Libs.Network.gson)
    implementation(Config.Libs.Network.gsonConverter)
    implementation(Config.Libs.Network.okhttp)
    implementation(Config.Libs.Network.okHttpLoggingInterceptor)

    implementation(Config.Libs.Mics.jsoup)
    // modules
    api(project(":core"))
}
