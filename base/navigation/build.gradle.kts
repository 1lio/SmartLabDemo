dependencies {
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)

    implementation(Config.Libs.Androidx.navigationUI)
    implementation(Config.Libs.Androidx.navigationFragment)
    implementation(Config.Libs.Androidx.navigationDynamic)

    androidTestImplementation(Config.Libs.Test.navigationTesting)

    // Navigation module знает о всех модулях кроеме app
    api(project(":core"))

    implementation(project(":account"))
    implementation(project(":chat"))
    implementation(project(":feed"))
    implementation(project(":splash"))
    implementation(project(":marketmap"))
    implementation(project(":stocklenta"))

}