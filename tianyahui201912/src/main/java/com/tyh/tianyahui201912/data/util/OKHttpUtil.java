package com.tyh.tianyahui201912.data.util;

import com.tyh.tianyahui201912.data.interceptor.LogInter;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OKHttpUtil {

    private final OkHttpClient okHttpClient;
    private static OKHttpUtil okHttpUtil;

    private OKHttpUtil(){
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInter())
                .build();

    }

    public static OKHttpUtil getInstertence(){
        if ( okHttpUtil== null) {
            synchronized (OKHttpUtil.class){
                if ( okHttpUtil== null) {
                    okHttpUtil = new OKHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    public void post(RequestBody requestBody, String uriString, Callback callback){
        Request build = new Request.Builder()
                .method("POST",requestBody)
                .url(uriString)
                .build();

        Call call = okHttpClient.newCall(build);
        call.enqueue(callback);
    }

}
