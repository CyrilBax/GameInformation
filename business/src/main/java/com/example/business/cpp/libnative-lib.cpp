//
// Created by cbaxiu on 21/11/2022.
//

#include <jni.h>
#include <string>

std::string getData() {
    std::string app_secret = "Null";

    app_secret = "b93e15401f5e4b6ba8e982d50e192f75";

    return app_secret;
}

extern "C" jstring
Java_com_example_business_data_datasources_implementations_RawgApiKeyDataSourceImpl_getApiKey(
        JNIEnv *env,
        jobject /* this */) {
    std::string app_secret = "Null";
    app_secret = getData();
    return env->NewStringUTF(app_secret.c_str());
}