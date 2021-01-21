rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "SmartLabDemo"

// base
include(":app")

addCore("core")


// features
addFeature("account")
addFeature("chat")
addFeature("feed")
addFeature("splash")
addFeature("marketmap")
addFeature("stocklenta")

addFeature("tabs")          // base tabs fragment


fun addFeature(moduleName: String) {
    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, "/features/$moduleName")
}


fun addCore(moduleName: String) {
    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, "/base/$moduleName")
}