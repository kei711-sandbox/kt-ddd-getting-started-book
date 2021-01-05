
rootProject.name = "kt-ddd-getting-started-book"

pluginManagement {
    val kotlinVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
            }
        }
    }
}
