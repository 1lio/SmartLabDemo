rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "SmartLabDemo"
val appID = "ru.smartlab.demo"

// base
include(":app")

addModule("core", isCore = true)

// features
addModule("account")
addModule("chat")
addModule("feed")
addModule("splash")
addModule("marketmap")
addModule("stocklenta")

//tmp
addModule("navigation", isCore = true)

fun addModule(moduleName: String, isCore: Boolean = false) {

    val moduleType = if (isCore) "base" else "features"

    // Check dir
    val modulePath = "$moduleType/$moduleName"
    val moduleDir = File(rootDir, modulePath)

    if (!moduleDir.exists()) {

        // make Module Directory
        moduleDir.mkdirs()

        // create build.gradle.kts file
        val gradleConfig = """
            dependencies {
                implementation(Config.Libs.Androidx.appCompat)
                implementation(Config.Libs.Androidx.core)
            }
        """.trimIndent()

        java.io.PrintWriter("$moduleType/$moduleName/build.gradle.kts").runCatching {
            this.println(gradleConfig)
            this.close()
        }.onFailure {
            it.printStackTrace()
        }

        // make Package Directory
        val packageID = appID.replace('.', '/')
        File(rootDir, "$moduleType/$moduleName/src/main/kotlin/$packageID/$moduleName").mkdirs()

        // add Manifest
        val manifest = """<?xml version="1.0" encoding="utf-8"?>
            |<manifest package="ru.smartlab.demo.$moduleName" />""".trimMargin()

        java.io.PrintWriter("$moduleType/$moduleName/src/main/AndroidManifest.xml").runCatching {
            this.println(manifest)
            this.close()
        }.onFailure {
            it.printStackTrace()
        }

    }

    //include module
    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, modulePath)
}
