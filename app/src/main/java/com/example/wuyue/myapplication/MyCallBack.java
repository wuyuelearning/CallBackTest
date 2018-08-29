package com.example.wuyue.myapplication;



/**
 * Created by wuyue on 2018/8/28.
 */

public class MyCallBack {

    private CallBack mCallBack;

    interface CallBack{
        void work();
    }
    void setCallBack(CallBack callBack){
        mCallBack =callBack;
        doWork();
    }

    private void doWork(){
        mCallBack.work();
    }
}
