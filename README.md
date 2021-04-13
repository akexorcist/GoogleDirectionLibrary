[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--GoogleDirectionAndPlaceLibrary-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1374)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/google-direction-library/badge.svg)](https://search.maven.org/artifact/com.akexorcist/google-direction-library)
![Minimum SDK Version](https://img.shields.io/badge/minSdkVersion-16-brightgreen) 
[![Workflow Status](https://github.com/akexorcist/GoogleDirectionLibrary/actions/workflows/android.yml/badge.svg)](https://github.com/akexorcist/GoogleDirectionLibrary/actions)

# Android-GoogleDirectionLibrary
![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_header.jpg)

Google Maps Direction API helper for Android

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_01.jpg)

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_02.jpg)


Download
===============================
Since version 2.1.2 will [move from JCenter to MavenCentral](https://developer.android.com/studio/build/jcenter-migration)
```groovy
// build.gradle (project)
allprojects {
    repositories {
        mavenCentral()
        /* ... */
    }
}
```

**Gradle**
```
implementation 'com.akexorcist:google-direction-library:1.2.1'
```


Sample Code
===============================

Simple Direction Request
```kotlin
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(LatLng(37.7681994, -122.444538))
        .to(LatLng(37.7749003,-122.4034934))
        .avoid(AvoidType.FERRIES)
        .avoid(AvoidType.HIGHWAYS)
        .execute(
            onDirectionSuccess = { direction: Direction? -> 
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }, 
            onDirectionFailure = { t: Throwable -> 
                // Do something
            }
        )
```


Multiple Waypoints Direction Request
```kotlin
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(LatLng(41.8838111, -87.6657851))
        .and(LatLng(41.8766061, -87.6556908))
        .and(LatLng(41.8909056, -87.6467561))
        .to(LatLng(41.9007082, -87.6488802))
        .transportMode(TransportMode.DRIVING)
        .execute(
            onDirectionSuccess = { direction: Direction? -> 
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }, 
            onDirectionFailure = { t: Throwable -> 
                // Do something
            }
        )
```

or 

```kotlin
val waypoints: List<LatLng> = listOf(
        LatLng(41.8766061, -87.6556908), 
        LatLng(41.8909056, -87.6467561)
)
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(LatLng(41.8838111, -87.6657851))
        .and(waypoints)
        .to(LatLng(41.9007082, -87.6488802))
        .transportMode(TransportMode.DRIVING)
        .execute(
            onDirectionSuccess = { direction: Direction? -> 
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }, 
            onDirectionFailure = { t: Throwable -> 
                // Do something
            }
        )
```

See example code for more detail

To get API key, please read [Get Google Maps Direction API Key](https://developers.google.com/maps/documentation/directions/get-api-key)


Demo
===============================

Try it at [Google Play](https://play.google.com/store/apps/details?id=com.akexorcist.googledirection.sample)


ProGuard
===========================
```
-keep class com.google.android.gms.maps.** { *; }
-keep interface com.google.android.gms.maps.* { *; }

-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-keep class com.akexorcist.googledirection.model.** { *;}
```


Change Log
====
See [CHANGELOG.md](CHANGELOG.md)


Licence
===========================
Copyright 2021 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

