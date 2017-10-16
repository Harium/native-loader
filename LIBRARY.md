## Generating a Native Library

This is a short tutorial to create native libraries using C language.

## Generate a Java File to handle the library

```
public class HelloWorld  {
    static {
        System.loadLibrary("hello");
    }
    public native void printHelloWorld();
}
```

## Compile the Java file
```
javac HelloWorld.java
```

## Generate the header file
```
javah -jni HelloWorld
```

```
#include <jni.h>
#include <stdio.h>
#include "HelloWorld.h"

JNIEXPORT jboolean JNICALL
Java_HelloWorld_print(JNIEnv *env, jobject obj) {
    printf("Hello World\n");
    return true;
}
```

In Fedora 25

```
gcc -I/usr/lib/jvm/java-1.8.0/include -I/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.111-1.b16.fc25.x86_64/include/linux/ -fPIC -shared -o libhello.so hello.c

```

In Solaris
```
gcc -I/java/include/solaris hello.c -o libhello.so
```

## Find the JNI header file
```
find / -name jni_md.h 2> /dev/null
```
