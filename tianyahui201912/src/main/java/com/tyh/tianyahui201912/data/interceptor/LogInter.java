package com.tyh.tianyahui201912.data.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogInter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.d("LogInter", "System.nanoTime()" + System.nanoTime());
        Headers headers = request.headers();
        String type = headers.get("content-type");
        String cache = headers.get("content-type");
        Response proceed = chain.proceed(request);
        Log.d("LogInter", "System.nanoTime()" + System.nanoTime());
        return proceed;
    }
}
