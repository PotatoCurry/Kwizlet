# Kwizlet
![Build Status](https://img.shields.io/travis/com/PotatoCurry/Kwizlet.svg)
![Release](https://img.shields.io/github/release/PotatoCurry/Kwizlet.svg)
![Issues](https://img.shields.io/github/issues/PotatoCurry/Kwizlet.svg)
![License](https://img.shields.io/github/license/PotatoCurry/Kwizlet.svg)

Simple Quizlet API wrapper

## Using Kwizlet

### Gradle
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    implementation 'com.github.PotatoCurry:Kwizlet:Tag'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.PotatoCurry</groupId>
    <artifactId>Kwizlet</artifactId>
    <version>Tag</version>
</dependency>
```

Additional instructions can be found [here](https://jitpack.io/#PotatoCurry/Kwizlet)

## Examples

### Print set contents
```kotlin
import io.github.potatocurry.kwizlet.api.Kwizlet

val clientID = "CLIENT_ID"
val setID = "SET_ID"

fun main() {
    val kwizlet = Kwizlet(clientID)
    val set = kwizlet.getSet(setID)
    val termMap = set.getTermMap()
    for ((term, definition) in termMap)
        println("$term: $definition")
}
```
