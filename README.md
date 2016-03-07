[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--GoogleDirectionAndPlaceLibrary-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1374) [![Build Status](https://travis-ci.org/akexorcist/Android-GoogleDirectionLibrary.svg?branch=master)](https://travis-ci.org/akexorcist/Android-GoogleDirectionLibrary) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/googledirectionlibrary/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/googledirectionlibrary) [![Methods Count](https://img.shields.io/badge/Methods and size-core: 561 | deps: 20617 | 112 KB-e91e63.svg)](http://www.methodscount.com/?lib=com.akexorcist%3Agoogledirectionlibrary%3A1.0.3)

# Android-GoogleDirectionLibrary
![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_header.jpg)

Android library for Google Maps Direction API for using with Google Maps for Android

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_01.jpg)

![Google Direction Library](https://raw.githubusercontent.com/akexorcist/Android-GoogleDirectionLibrary/master/image/google-direction-library_02.jpg)


Sample Code
===============================

```java
GoogleDirection.withServerKey("YOUR_SERVER_API_KEY")
        .from(new LatLng(37.7681994, -122.444538))
		    .to(new LatLng(37.7749003,-122.4034934))
		    .avoid(AvoidType.FERRIES)
		    .avoid(AvoidType.HIGHWAYS)
		    .execute(new DirectionCallback() {
    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
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
  <version>1.0.3</version>
</dependency>
```

Gradle
```
compile 'com.akexorcist:googledirectionlibrary:1.0.3'
```

Usage Documentation
===============================
English Version : http://www.akexorcist.com/2015/12/google-direction-library-for-android-en.html

Thai Version : http://www.akexorcist.com/2015/12/google-direction-library-for-android-th.html


Licence
===========================
Copyright 2015 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

