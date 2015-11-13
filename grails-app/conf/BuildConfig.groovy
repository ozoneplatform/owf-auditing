grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        mavenRepo "https://repo1.maven.org/maven2"
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
    plugins {
        compile(':release:3.1.1', ':hibernate:3.6.10.14', ':quartz:1.0.1') {
            export = false
        }
    }
}

grails.release.scm.enabled = false

//Sonatype-run maven central
grails.project.repos.ossrhSnapshots.url =
    'https://oss.sonatype.org/content/repositories/snapshots'
grails.project.repos.ossrhReleases.url =
    'https://oss.sonatype.org/service/local/staging/deploy/maven2/'

grails.project.repos.default = "ossrhSnapshots"
