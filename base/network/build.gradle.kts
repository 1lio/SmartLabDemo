dependencies {
    // libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)

    implementation(Config.Libs.Kotlin.coroutinesCore)

    // Network
    implementation(Config.Libs.Mics.jsoup)
    implementation(Config.Libs.Network.retrofit2)
    implementation(Config.Libs.Network.gson)
    implementation(Config.Libs.Network.gsonConverter)
    implementation(Config.Libs.Network.okhttp)
    implementation(Config.Libs.Network.okHttpLoggingInterceptor)

    // modules
    api(project(":core"))
}
