#include <jni.h>
#include <string>
#include "my-cpp_lib.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_bpapps_opencvnativedemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jint JNICALL
Java_com_bpapps_opencvnativedemo_MainActivity_getSumPlusOne(JNIEnv *env, jobject thiz, jint num) {
    return num + 1;
}


extern "C" JNIEXPORT jdouble JNICALL
Java_com_bpapps_opencvnativedemo_MainActivity_getSquareRoot(JNIEnv *env, jobject thiz, jdouble  num) {
    return squareRoot(num);
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_bpapps_opencvnativedemo_MainActivity_getSRnPowM(JNIEnv *env, jobject thiz, jdouble  n, jdouble  m) {
    double basis = squareRoot(n);
    return pow(basis, m);
}
