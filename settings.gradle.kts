pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
            credentials {
                username = "patelvishal937"
                password = "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"
            }
        }
    }
}

rootProject.name = "quest_package"
include(":app")
include(":quest-package")
