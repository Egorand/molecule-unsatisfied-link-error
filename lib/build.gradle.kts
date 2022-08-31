plugins {
  id("com.android.library")
  id("kotlin-android")
  id("app.cash.molecule")
  id("app.cash.paparazzi")
}

android {
  namespace = "dev.egorand.stonkstesting.ui"
  compileSdk = 33

  defaultConfig {
    minSdk = 24
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.3.0"
  }
  testOptions {
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  testImplementation("junit:junit:4.13.2")
  testImplementation("app.cash.turbine:turbine:0.9.0")
}
