# gradle-plugin-template

[![Build Status](https://travis-ci.org/ksoichiro/gradle-plugin-template.svg?branch=master)](https://travis-ci.org/ksoichiro/gradle-plugin-template)
[![Build status](https://ci.appveyor.com/api/projects/status/sp76ckciaygit9tm?svg=true)](https://ci.appveyor.com/project/ksoichiro/gradle-plugin-template)
[![Coverage Status](https://coveralls.io/repos/ksoichiro/gradle-plugin-template/badge.svg?branch=master&service=github)](https://coveralls.io/github/ksoichiro/gradle-plugin-template?branch=master)

Template project for Gradle plugin.

## Usage

1. Clone this repository or download as a ZIP file.  
   If you choose cloning, remove `.git` directory and initialize repository again (`git init`).
1. Rename project directory to your plugin name. (e.g. gradle-awesome-plugin)
1. Configure some codes to identify your plugin and to fit your requirements. See the [following section](#what-you-need-to-do-before-development) for details.

## Features

### Groovy development

* Gradle wrapper is included.
* Plugins to develop plugin are already defined.
* Source directories are prepared to write codes in Groovy. See `src/main/groovy` directory.

### Code quality

* Simple JUnit test codes are prepared. By executing `./gradlew test`, test will be executed.
    * Report file location: `build/reports/tests/index.html`
* Cobertura coverage report is prepared. By executing `./gradlew cobertura`, coverage report will be generated.
    * Report file location: `build/reports/cobertura/index.html`
* `.editorconfig` file for [EditorConfig](http://editorconfig.org/) is included to keep clean format.

### Plugin publishing configuration

You can publish plugin easily to Maven Central via Sonatype and to Gradle Plugin Portal.

#### Local repository

* `./gradlew uploadArchives` will publish artifacts to local directory(defaults to `rootDir/.repo`).

#### Maven Central repository

* `./gradlew uploadArchives -Prelease` will publish artifacts to Sonatype repository.

    >  You must create an account and your repository on Sonatype.

* When the version has `-SNAPSHOT` suffix, `./gradlew uploadArchives -Prelease` will upload artifacts to snapshot repository and your plugin can be used by anyone instantly.
* When the version does NOT have `-SNAPSHOT` suffix, `./gradlew uploadArchives -Prelease` will upload artifacts to release repository. After executing it, you should release manually at `oss.sonatype.org`.

#### Gradle Plugin Portal

* `./gradlew clean build publishPlugins` will publish artifacts to Gradle Plugin Portal.

### CI configuration

#### Travis CI

`.travis.yml` is prepared in case you use [Travis CI](https://travis-ci.org).

#### AppVeyor

`appveyor.yml` is prepared in case you use [AppVeyor](http://www.appveyor.com/).

## What you need to do before development

### Update Gradle version

Edit the Gradle version of the `distributionUrl` in `gradle/wrapper/gradle-wrapper.properties`.

### Update plugin information

Edit `gradle/meta.gradle`.  
This file defines meta information such as version, package name, repository URL, etc.

### Update Groovy source code

* Rename package, classes in the `src/main/groovy` directory.  
You should do it with IDE's refactoring features.
* Fix TODOs in the Groovy source codes.
* Rename `com.example.template.properties` in `resources/META-INF/gradle-plugins` directory to `your.plugin.id.properties`.

    > What the package name and ID should be is described in the [Gradle user guide](https://docs.gradle.org/current/userguide/custom_plugins.html).

### Update README

Edit `README.template.md` and move it to `README.md`.  
This document (`README.md`) is NOT a part of the plugin template files.

### Update License

If you choose a license other than Apache License v2, please remove `LICENSE` and add appropriate notice document.

### Configure gradle.properties

Set the following credential properties in the `$USER_HOME/.gradle/gradle.properties` or `projectRootDir/gradle.properties`.  
DO NOT add these properties to the version control.

These values are required to publish plugin to Maven Central via Sonatype OSSRH.
See [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for details.

```properties
signing.keyId=XXXX
signing.password=XXXX
signing.secretKeyRingFile=XXXX
ossrhUsername=XXXX
ossrhPassword=XXXX
```

These values are required to publish plugin to Gradle Plugin Portal.
`./gradlew login` will generate them.
See [here](https://plugins.gradle.org/docs/submit) for details.

```properties
gradle.publish.key=XXXX
gradle.publish.secret=XXXX
```

### And...

Star this project if you like it ;)  
Now you're ready to write and publish your awesome plugin!

## License

    Copyright 2015 Soichiro Kashima

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
