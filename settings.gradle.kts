rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "SmartLabDemo"

// base
include(":app")

// features
addFeature("account")
addFeature("chat")
addFeature("feed")
addFeature("splash")
addFeature("marketmap")

addFeature("tabs")          // base tabs fragment


fun addFeature(moduleName: String) {
    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, "/features/$moduleName")
}
