[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--GoogleDirectionAndPlaceLibrary-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1374) [![Build Status](https://travis-ci.org/akexorcist/Android-GoogleDirectionLibrary.svg?branch=master)](https://travis-ci.org/akexorcist/Android-GoogleDirectionLibrary) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/googledirectionlibrary/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/googledirectionlibrary)

# Android-GoogleDirectionLibrary
![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_header.jpg)

Android library for Google Maps Direction API for using with Google Maps for Android

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_01.jpg)

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_02.jpg)


Sample Code
===============================

Simple Direction Request
```java
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(new LatLng(37.7681994, -122.444538))
        .to(new LatLng(37.7749003,-122.4034934))
        .avoid(AvoidType.FERRIES)
        .avoid(AvoidType.HIGHWAYS)
        .execute(new DirectionCallback() {
            @Override
            public void onDirectionSuccess(Direction direction) {
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }

            @Override
            public void onDirectionFailure(Throwable t) {
                // Do something
            }
        });
```


Multiple Waypoints Direction Request
```java
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(new LatLng(41.8838111, -87.6657851))
        .and(new LatLng(41.8766061, -87.6556908))
        .and(new LatLng(41.8909056, -87.6467561))
        .to(new LatLng(41.9007082, -87.6488802))
        .transportMode(TransportMode.DRIVING)
        .execute(new DirectionCallback() {
            @Override
            public void onDirectionSuccess(Direction direction) {
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }

            @Override
            public void onDirectionFailure(Throwable t) {
                // Do something
            }
        });
```

or 

```java
List<LatLng> waypoints = Arrays.asList(
        new LatLng(41.8766061, -87.6556908), 
        new LatLng(41.8909056, -87.6467561)
)
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(new LatLng(41.8838111, -87.6657851))
        .and(waypoints)
        .to(new LatLng(41.9007082, -87.6488802))
        .transportMode(TransportMode.DRIVING)
        .execute(new DirectionCallback() {
            @Override
            public void onDirectionSuccess(Direction direction) {
                if(direction.isOK()) {
                    // Do something
                } else {
                    // Do something
                }
            }

            @Override
            public void onDirectionFailure(Throwable t) {
                // Do something
            }
        });
```

See example code for more detail

To get API key, please read [Get Google Maps Direction API Key](https://developers.google.com/maps/documentation/directions/get-api-key)


Demo
===============================

Try it at [Google Play](https://play.google.com/store/apps/details?id=com.akexorcist.googledirection.sample)


Download
===============================

Maven
```
<dependency>
  <groupId>com.akexorcist</groupId>
  <artifactId>googledirectionlibrary</artifactId>
  <version>1.1.1</version>
</dependency>
```

Gradle
```
implementation 'com.akexorcist:googledirectionlibrary:1.1.1'
```

Usage Documentation
===============================
English Version : http://www.akexorcist.com/2015/12/google-direction-library-for-android-en.html

Thai Version : http://www.akexorcist.com/2015/12/google-direction-library-for-android-th.html


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
```

Special Thank
===========================
[@jonaslins](https://github.com/jonaslins)

[@Will1229](https://github.com/Will1229)

Licence
===========================
Copyright 2017 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

