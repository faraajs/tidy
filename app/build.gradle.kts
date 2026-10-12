import java.util.Properties

plugins {
    id("com.android.application")
}

// Optional private properties live outside the checkout; environment values take precedence.
val signingProperties = Properties()
providers.environmentVariable("TIDY_SIGNING_PROPERTIES").orNull?.let { location ->
    val privateFile = file(location)
    require(!privateFile.toPath().toRealPath().startsWith(rootDir.toPath().toRealPath())) {
        "TIDY_SIGNING_PROPERTIES must be outside the source checkout"
    }
    privateFile.inputStream().use { signingProperties.load(it) }
}
fun signingValue(environment: String, property: String): String? =
    providers.environmentVariable(environment).orNull ?: signingProperties.getProperty(property)

val releaseStore = signingValue("TIDY_KEYSTORE", "storeFile")
val releaseStorePassword = signingValue("TIDY_STORE_PASSWORD", "storePassword")
val releaseAlias = signingValue("TIDY_KEY_ALIAS", "keyAlias")
val releaseKeyPassword = signingValue("TIDY_KEY_PASSWORD", "keyPassword")
val signingValues = listOf(releaseStore, releaseStorePassword, releaseAlias, releaseKeyPassword)
require(signingValues.all { it == null } || signingValues.all { !it.isNullOrBlank() }) {
    "Release signing requires all four TIDY signing values, or none for an unsigned APK"
}

android {
    namespace = "id.eska.screenshotwebp"
    compileSdk = 36
    ndkVersion = "27.1.12297006"

    defaultConfig {
        applicationId = "id.eska.tidy"
        minSdk = 30
        targetSdk = 36
        versionCode = 4
        versionName = "2.3.1"
        testInstrumentationRunner = "id.eska.screenshotwebp.ConversionInstrumentation"
        ndk {
            abiFilters += listOf("arm64-v8a", "x86_64")
        }
        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
                arguments += "-DANDROID_SUPPORT_FLEXIBLE_PAGE_SIZES=ON"
            }
        }
    }

    if (releaseStore != null) {
        signingConfigs {
            create("release") {
                storeFile = file(requireNotNull(releaseStore))
                storePassword = releaseStorePassword
                keyAlias = releaseAlias
                keyPassword = releaseKeyPassword
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            if (releaseStore != null) signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation("androidx.exifinterface:exifinterface:1.4.2")
    testImplementation("junit:junit:4.13.2")
}
