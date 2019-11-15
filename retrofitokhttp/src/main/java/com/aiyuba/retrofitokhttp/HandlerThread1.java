package com.aiyuba.retrofitokhttp;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by maoyujiao on 2019/11/5.
 */

public class HandlerThread1 extends Handler {

    public HandlerThread1(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case 1:
                System.out.println("子线程收到消息了");
                break;
        }
    }
}
