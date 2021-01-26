package com.itsz.buildsrc


object Versions {
  val coreKtx = "1.3.2"
  val appcompat = "1.2.0"
  val constraintlayout = "2.0.4"
  val fragment = "1.2.5"
  val junit = "4.13.1"
  val junitExt = "1.1.2"
  val espressoCore = "3.3.0"
  val lifecycle_version = "2.2.0"
  val retrofit = "2.9.0"
  val okhttpLogging = "4.9.0"
  val paging = "3.0.0-alpha02"
  val timber = "4.7.1"
  val kotlin = "1.4.21"
  val autodispose2 = "2.0.0"
  val work = "2.2.0"
  val room = "2.3.0-alpha01"
  val cardview = "1.0.0"
  val recyclerview = "1.0.0"
  val swiperefreshlayout = "1.0.0"
  val hit = "2.28-alpha"
  val hitViewModule = "1.0.0-alpha01"
  val appStartup = "1.0.0-alpha01"
  val material = "1.2.0"
  val stetho = "1.5.1"
  val coroutines = "1.3.9"
  val navigation = "2.3.1"
}

/**
 * [https://developer.android.com/jetpack/androidx/releases/core]
 */
object AndroidX {
  val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
  val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
  val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"

  val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
  val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
  val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
  val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle_version}"

  // 提供整个应用程序过程的生命周期
  val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle_version}"

  val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
  val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

  val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"

  val workRuntime = "androidx.work:work-runtime:${Versions.work}"
  val workTesting = "androidx.work:work-testing:${Versions.work}"
  val cardview = "androidx.cardview:cardview:${Versions.cardview}"
  val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
  val swiperefreshlayout =
    "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"

  val appStartup = "androidx.startup:startup-runtime:${Versions.appStartup}"
}

object JTest {
  val junit = "junit:junit:${Versions.junit}"
  val androidTestJunit = "androidx.test.ext:junit:${Versions.junitExt}"
  val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object Android {
  val material = "com.google.android.material:material:${Versions.material}"
}

object Hilt {
  val daggerRuntime = "com.google.dagger:hilt-android:${Versions.hit}"
  val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hit}"
  val viewModule = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hitViewModule}"
  val compiler = "androidx.hilt:hilt-compiler:${Versions.hitViewModule}"
}


object Room {
  val runtime = "androidx.room:room-runtime:${Versions.room}"
  val compiler = "androidx.room:room-compiler:${Versions.room}"
  val ktx = "androidx.room:room-ktx:${Versions.room}"
  val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
  val testing = "androidx.room:room-testing:${Versions.room}"
}

object Fragment {
  val runtime = "androidx.fragment:fragment:${Versions.fragment}"
  val runtimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
  val testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
}

object Kt {
  val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
  val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
  val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
  val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
  val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
  val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}


object Retrofit {
  val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
  val adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
  val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
  val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
}

object Rx {
  val rxJava = "io.reactivex.rxjava3:rxjava:3.0.7"
  val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
}

object DebugDep {
  val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
  val stethoOkhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
  val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.6"
}

object Depend {
  val timber = "com.jakewharton.timber:timber:${Versions.timber}"
  val utilCode = "com.blankj:utilcode:1.30.4"
  val autodispose2 = "com.uber.autodispose2:autodispose-android:${Versions.autodispose2}"
  val autodispose2Lifecycle = "com.uber.autodispose2:autodispose-androidx-lifecycle:${Versions.autodispose2}"
}

