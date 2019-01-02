package com.tyh.tianyahui201912.di.presonter;

import com.tyh.tianyahui201912.di.centerdaata.Conterceon;
import com.tyh.tianyahui201912.di.model.MianModel;

import java.lang.ref.SoftReference;

public class MainPresonter implements Conterceon.iPresonter<Conterceon.IView> {

    Conterceon.IView iView;
    private SoftReference<Conterceon.IView> softReference;
    private MianModel mianModel;

    @Override
    public void bindingData(Conterceon.IView iView) {
        this.iView = iView;
        softReference = new SoftReference<>(iView);
        mianModel = new MianModel();
    }

    @Override
    public void unbundelData(Conterceon.IView iView) {

        softReference.clear();
    }

    @Override
    public void conModelData() {

        mianModel.resentaData(new Conterceon.iModel.CallBack() {
            @Override
            public void requestData(String requestData) {
                iView.showData(requestData);
            }
        });
    }
}
