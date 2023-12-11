# daggerfx

The Dagger [coffee example](https://github.com/google/dagger/tree/master/examples/maven/coffee)
applied to a modular JavaFX 11 application, which uses Dagger for dependency injection of 
JavaFX controllers and services.

----

This fork adds the Gradle build script, creates [jlink image](https://dzone.com/articles/jlink-in-java-9),
and builds native image with [GraalVM native-image](https://www.graalvm.org/reference-manual/native-image/)
utility.

## Gradle build tasks

### Building for standard JVM environment

To build and run the `daggerfx` application in standard JVM environment, execute the Gradle `run` task:

	gradlew run

To create an executable uber jar which includes all dependencies for the current platform:

	gradlew uberJar

and the resulting `daggerfx-1.0.0-SNAPSHOT-no-deps-<currentPlatform>.jar` file should be created in
`build/libs` directory, and can be executed directly with the `java -jar` command, e.g. in a Linux box:

	java -jar build/libs/daggerfx-1.0.0-SNAPSHOT-no-deps-linux.jar

(or if building on a Windows machine:

	java -jar build\libs\daggerfx-1.0.0-SNAPSHOT-no-deps-win.jar

)

To produce a [jlink image](https://dzone.com/articles/jlink-in-java-9)
of the `daggerfx` application for the current platform, execute the `jlink` task:

	gradlew jlink

The resulting jlink image is in the folder:

	build/daggerfx-0.0.1-SNAPSHOT-<currentPlatform>

which can then be executed directly, for example in Linux:

	./build/daggerfx-0.0.1-SNAPSHOT-linux/bin/daggerfx

(or if building on a Windows machine:

	build\daggerfx-0.0.1-SNAPSHOT-win\bin\daggerfx.bat

)

### Building native executable

`daggerfx` can be compiled to a stand-alone native executable, e.g. producing `daggerfx.exe` in Windows,
using the [GraalVM native-image](https://www.graalvm.org/reference-manual/native-image) utility.
The link shows how to set up GraalVM and its native-image utility for common platforms.
[Gluon](https://gluonhq.com/) also provides some setup [details](https://docs.gluonhq.com/#_platforms)
for GraalVM native image creation.

The Gradle build script uses [gluonfx-gradle-plugin](https://github.com/gluonhq/gluonfx-gradle-plugin)
from Gluon to build the native executable from Gradle with GraalVM.
GraalVM native-image utility will use the configuration files in
`src/graal-cfg/<currentPlatform>/META-INF/native-image` folder
to assist in native-image generation.

Once the GraalVM prerequisites are set up for the current platform,
run the `nativeBuild` task to produce a native executable:

	gradlew nativeBuild

The `nativeBuild` task will take a while to finish, resulting in a native executable file at, e.g. in a Linux box:

	./build/gluonfx/x86_64-linux/daggerfx

(or if building on a Windows machine:

	build\gluonfx\x86_64-windows\daggerfx.exe

)

## Maven build tasks

### Building for standard JVM environment

To build and run the `daggerfx` application in standard JVM environment, execute the Maven
`javafx:run` task:

	mvnw javafx:run

To create an executable uber jar which includes all dependencies for the current platform:

	mvnw package

and the resulting `daggerfx-1.0.0-SNAPSHOT-no-deps-<currentPlatform>.jar` file should be created in
`target` directory, and can be executed directly with the `java -jar` command, e.g. in a Linux box:

	java -jar target/daggerfx-1.0.0-SNAPSHOT-no-deps-linux.jar

(or if building on a Windows machine:

	java -jar target\daggerfx-1.0.0-SNAPSHOT-no-deps-win.jar

)

The above `mvnw package` command also produces a [jlink image](https://dzone.com/articles/jlink-in-java-9)
of the `daggerfx` application, for the current platform, in the folder:

	target/daggerfx-0.0.1-SNAPSHOT-<currentPlatform>

which can then be executed directly, for example in Linux:

	./target/daggerfx-0.0.1-SNAPSHOT-linux/bin/daggerfx

(or if building on a Windows machine:

	target\daggerfx-0.0.1-SNAPSHOT-win\bin\daggerfx.bat

)

### Building native executable

`daggerfx` can be compiled to a stand-alone native executable, e.g. producing `daggerfx.exe` in Windows,
using the [GraalVM native-image](https://www.graalvm.org/reference-manual/native-image) utility.
The link shows how to set up GraalVM and its native-image utility for common platforms.
[Gluon](https://gluonhq.com/) also provides some setup [details](https://docs.gluonhq.com/#_platforms)
for GraalVM native image creation.

The Maven build script uses [gluonfx-maven-plugin](https://github.com/gluonhq/gluonfx-maven-plugin)
from Gluon to build the native executable from Maven with GraalVM.
GraalVM native-image utility will use the configuration files in
`src/graal-cfg/<currentPlatform>/META-INF/native-image` folder
to assist in native-image generation.

Once the GraalVM prerequisites are set up for the current platform,
run the `gluonfx:build` task to produce a native executable:

	mvnw gluonfx:build

The `gluonfx:build` task will take a while to finish, resulting in a native executable file at, e.g. in a Linux box:

	./target/gluonfx/x86_64-linux/daggerfx

(or if building on a Windows machine:

	target\gluonfx\x86_64-windows\daggerfx.exe

)

