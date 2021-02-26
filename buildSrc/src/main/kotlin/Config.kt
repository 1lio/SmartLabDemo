object Config {
    // app
    const val appVersionName = "1.0.0"
    const val appVersionCode = 1
    const val buildTools = "30.0.3"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val mainDir = "src/main/kotlin"
    const val testDir = "src/test/kotlin"
    const val androidTestDir = "src/androidTest/kotlin"

    const val applicationID = "ru.smartlab.demo"

    private const val kotlinVersion = "1.4.31"
    private const val navVersion = "2.3.3"

    object SdkVersions {
        const val compile = 30
        const val target = 30
        const val min = 23
    }

    object Plugins {
        const val gradleAndroid = "com.android.tools.build:gradle:4.1.2"
        const val gradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val googleServices = "com.google.gms:google-services:4.3.4"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.33-beta"
    }

    object Libs {

        object Kotlin {
            private const val ver = "1.4.2"
            const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$ver"
            const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$ver"
            const val coroutinesPlayServices =
                "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$ver"
        }

        object Androidx {
            private const val livedataVer = "2.2.0"

            const val appCompat = "androidx.appcompat:appcompat:1.2.0"
            const val core = "androidx.core:core-ktx:1.3.2"
            const val ktxCollection = "androidx.collection:collection-ktx:1.1.0"
            const val ktxFragment = "androidx.fragment:fragment-ktx:1.2.5"
            const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"

            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$livedataVer"
            const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:$livedataVer"
            const val livedata = "androidx.lifecycle:lifecycle-viewmodel-ktx:$livedataVer"

            const val viewpager = "androidx.viewpager:viewpager:1.0.0"
            const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val material = "com.google.android.material:material:1.2.1"
            const val vectorAnimation = "androidx.vectordrawable:vectordrawable-animated:1.1.0"

            // NavigationLibs

            const val navigationUI = "androidx.navigation:navigation-fragment-ktx:$navVersion"
            const val navigationFragment = "androidx.navigation:navigation-ui-ktx:$navVersion"

            // Feature module Support
            const val navigationDynamic =
                "androidx.navigation:navigation-dynamic-features-fragment:$navVersion"

            private const val hiltVer = "2.33-beta"

            const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVer"
            const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVer"
            const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        }

        object Mics {
            // Surf Libs
            const val surfEasyAdapter = "ru.surfstudio.android:easyadapter:2.0.0"
            const val surfRecyclerDecorator = "ru.surfstudio.android:recycler-decorator:1.0.0"

            // Other

            // Java HTML Parser
            const val jsoup = "org.jsoup:jsoup:1.13.1"

            // SharedPref
            const val hawk = "com.orhanobut:hawk:2.0.1"

            // Images Network
            const val picasso = "com.squareup.picasso:picasso:2.71828"
        }

        object Compose {
            // Navigation
            const val navigationCompose = "androidx.navigation:navigation-compose:1.0.0-alpha05"
        }

        object Firebase {
            private const val bomVer = "26.0.0"

            const val bom = "com.google.firebase:firebase-bom:$bomVer"
            const val auth = "com.google.firebase:firebase-auth-ktx"
            const val database = "com.google.firebase:firebase-database-ktx"
            const val storage = "com.google.firebase:firebase-storage-ktx"
        }

        object Google {
            const val auth = "com.google.android.gms:play-services-auth:18.1.0"
            const val maps = "com.google.android.gms:play-services-maps:17.0.0"
        }

        object Network {
            private const val retrofitVer = "2.9.0"

            const val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofitVer"
            const val gson = "com.google.code.gson:gson:2.8.6"
            const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVer"

            const val okhttp = "com.squareup.okhttp3:okhttp:4.5.0"
            const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.8.1"
            const val websocket = "org.java-websocket:Java-WebSocket:1.5.1"

            const val retrofitCoroutinesAdapter =
                "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        }

        object Rx {
            const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
        }


        object Test {
            const val testRunner = "androidx.test:runner:1.3.0"
            const val testRules = "androidx.test:rules:1.3.0"
            const val testMonitor = "androidx.test:rules:1.3.0"
            const val testJunitKtx = "androidx.test.ext:junit-ktx:1.1.2"
            const val testCoreKtx = "androidx.test:core-ktx:1.3.0"

            const val junit = "junit:junit:4.13.1"

            const val junitExt = "androidx.test.ext:junit:1.1.2"
            const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
            const val espressoIntents = "androidx.test.espresso:espresso-intents:3.3.0"
            const val mockk = "io.mockk:mockk:1.10.2"
            const val robolectric = "org.robolectric:robolectric:4.4"
            //    const val supportRunner = "com.android.support.test:runner:1.0.2"

            // Testing Navigation
            const val navigationTesting = "androidx.navigation:navigation-testing:$navVersion"
        }
    }

    object Proguard {
        const val file = "proguard-android-optimize.txt"
        const val rules = "proguard-rules.pro"
    }

    object BuildType {
        const val release = "release"
        const val debug = "debug"
    }
}