package com.example.wuyue.myapplication;

/**
 * Created by wuyue on 2018/8/28.
 */

public class MyCallBackImpl implements ISetCallBack {

    @Override
    public void setCallBack(IMyCallBack callBack2) {
        Auther util =new Auther();
        callBack2.onCallBack();
        util.tran(callBack2);
    }

    @Override
    public void setCallBack(IMyCallBack callBack2, int i) {
        if(i==1){
            callBack2.onCallBack2();
        } else {
            callBack2.onCallBack();
        }
    }
}
