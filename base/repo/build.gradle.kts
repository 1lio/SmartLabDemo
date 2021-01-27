dependencies {

    // libs
    implementation(Config.Libs.Kotlin.coroutinesCore)
    implementation(Config.Libs.Mics.jsoup)

    // modules
    api(project(":core"))
}
