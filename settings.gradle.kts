rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "SmartLabDemo"

// base
include(":app")

addModule("core", isCore = true)
// addModule("repo", isCore = true)
// addModule("network", isCore = true)

// features
// addModule("auth")
// addModule("account")
// addModule("chat")
// addModule("feed")
// addModule("splash")
// addModule("marketmap")
// addModule("stocklenta")

//tmp
// addModule("navigation", isCore = true)

val appID = "ru.smartlab.demo"

// Add gradle module
fun addModule(moduleName: String, isCore: Boolean = false) {

    val moduleType = if (isCore) "base" else "features"

    // Check dir
    val modulePath = "$moduleType/$moduleName"
    val moduleDir = File(rootDir, modulePath)

    if (!moduleDir.exists()) moduleDir.addTemplate(moduleName, moduleType)

    // Include module
    include(moduleName)
    project(":$moduleName").projectDir = File(rootDir, modulePath)
}

// Add module template (dirs, build.gradle.kts, manifest)
fun File.addTemplate(moduleName: String, moduleType: String) {

    // make Module Directory
    this.mkdirs()

    // create build.gradle.kts file
    val gradleConfig = """
            dependencies {
                // libs
                implementation(Config.Libs.Androidx.appCompat)
                implementation(Config.Libs.Androidx.core)
                implementation(Config.Libs.Androidx.material)
                
                // modules
                api(project(":core"))
                // api(project(":network"))
            }
        """.trimIndent()

    // push and save gradle file
    gradleConfig.pushToFile("$moduleType/$moduleName/build.gradle.kts")

    // make Package Directory
    val packageID = appID.replace('.', '/')
    File(rootDir, "$moduleType/$moduleName/src/main/kotlin/$packageID/$moduleName").mkdirs()

    // push and save Manifest
    val manifest = """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest package="$appID.$moduleName" />""".trimIndent()

    manifest.pushToFile("$moduleType/$moduleName/src/main/AndroidManifest.xml")
}

fun String.pushToFile(path: String) {
    java.io.PrintWriter(path).runCatching {
        this.println(this@pushToFile)
        this.close()
    }.onFailure { it.printStackTrace() }
}