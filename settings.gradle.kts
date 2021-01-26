rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "SmartLabDemo"

// base
include(":app")

addCore("core")
//addCore("navigation")

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

    // Check dir
    val modulePath = "base/$moduleName"
    val moduleDir = File(rootDir, modulePath)

    if (!moduleDir.exists()) {

        // make Module Directory
        moduleDir.mkdir()

        // create build.gradle.kts file
        val gradleConfig = """
            dependencies {
                implementation(Config.Libs.Androidx.appCompat)
                implementation(Config.Libs.Androidx.core)
            }
        """.trimIndent();

        val gradleFile = File( "//$moduleName/build.gradle.kts", gradleConfig)

        gradleFile.createNewFile()

        // make Package Directory
    }

    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, modulePath)
}