# Bitmapji
Emoji as Bitmap for Android

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.commit451/bitmapji/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.commit451/bitmapji)

## Gradle
```groovy
dependencies {
    implementation("com.commit451:bitmapji:latest.release.here")
}
```

## Usage
```kotlin
val size = resources.getDimensionPixelSize(R.dimen.bitmap_size)
val bitmap = Bitmapji.create(
    this,
    "\uD83D\uDD25",
    size.toFloat()
)
// do something with the bitmap
imageView.setImageBitmap(bitmap)
```

License
--------

    Copyright 2022 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
