package com.tyh.tianyahui201912.di.model;

import com.tyh.tianyahui201912.data.util.OKHttpUtil;
import com.tyh.tianyahui201912.di.centerdaata.Conterceon;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

public class MianModel implements Conterceon.iModel {
    String urlString = "http://www.zhaoapi.cn/home/getHome";

    @Override
    public void resentaData(CallBack callBack) {

        newceshow(callBack);
    }

    private void newceshow(final CallBack callBack) {

        FormBody formBody = new FormBody.Builder().build();

        OKHttpUtil.getInstertence().post(formBody, urlString, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack.requestData(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                callBack.requestData(string);

            }
        });

    }
}
