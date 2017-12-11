[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

![Logo](assets/logo.png)

# Kripton
Es una librería que permite a los desarrolladores crear aplicaciones robustas para Android implementando el patrón MVP de forma simple.

## Cómo utilizarlo
__Paso 1.__ Agregar el repositorio JitPack en el archivo build
```groovy
   allprojects {
      repositories {
         ...
         maven { url 'https://jitpack.io' }
      }
   }
```

__Paso 2.__ Agregar la dependencia
```python
    dependencies {
		// mvp
        compile 'com.github.gigigoandroidmx.kripton:kmvp:v2.0.1'
		// extensiones retrofit
        compile 'com.github.gigigoandroidmx.kripton:kretrofitmanager:v2.0.1'
		// view base
        compile 'com.github.gigigoandroidmx.kripton:kbase:v2.0.1'
		// branding
        compile 'com.github.gigigoandroidmx.kripton:kbranding:v2.0.1'
    }
```

# License
```
Copyright (c) 2017 Gigigo Android Development Team México


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
