rootProject.name = "wbxml-stream"


pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("jaxb-api", "4.0.0")
            version("jaxb-runtime", "4.0.3")
            version("xerces", "2.12.2")
            version("guava", "32.1.2-jre")

            library("jaxb-api", "jakarta.xml.bind", "jakarta.xml.bind-api").versionRef("jaxb-api")
            library("jaxb-runtime", "org.glassfish.jaxb", "jaxb-runtime").versionRef("jaxb-runtime")

            library("xercesImpl", "xerces", "xercesImpl").versionRef("xerces")

            library("guava", "com.google.guava", "guava").versionRef("guava")
        }

        create("testLibs"){
            version("testng", "7.8.0")
            version("xmlunit", "1.6")
            version("jx-activation", "1.2.0")

            library("testng", "org.testng", "testng").versionRef("testng")
            library("xmlunit", "xmlunit", "xmlunit").versionRef("xmlunit")
            library("jx-activation", "com.sun.activation","javax.activation").versionRef("jx-activation")
        }
    }
}