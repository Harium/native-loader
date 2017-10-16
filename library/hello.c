#include "HelloWorld.h"
#include <stdio.h>
#include <stdbool.h>
#include <jni.h>

JNIEXPORT jboolean JNICALL
Java_HelloWorld_printHelloWorld(JNIEnv *env, jobject obj) {
    printf("Hello World\n");
    return true;
}
