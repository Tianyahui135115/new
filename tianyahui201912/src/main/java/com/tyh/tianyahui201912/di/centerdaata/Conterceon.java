package com.tyh.tianyahui201912.di.centerdaata;

public interface Conterceon {

    public interface IView{
        //展示数据
        public void showData(String requestData);
    }

    public interface iPresonter<IView>{
        //绑定
        public void bindingData(IView iView);
        //解绑

        public void unbundelData(IView iView);

        public void conModelData();

    }

    public interface iModel{
        public void resentaData(CallBack callBack);

        public interface CallBack{
            public void requestData(String requestData);
        }
    }
}
