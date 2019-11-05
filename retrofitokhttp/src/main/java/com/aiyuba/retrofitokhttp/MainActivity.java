package com.aiyuba.retrofitokhttp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Handler threadHandler;
    private Handler mainHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    System.out.println("主线程收到消息了");
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        textView.setText(getClass().getSimpleName());
//        Call<ResponseBody> call = HttpInstance.getInstance().getUserInfo("rengwuxian");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.e(getClass().getSimpleName(),response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e(getClass().getSimpleName(),t.getMessage());
//
//            }
//        });

        new Thread(){
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                threadHandler = new HandlerThread1(Looper.myLooper());
                Message message = new Message();
                message.what = 1;
                threadHandler.sendMessage(message);
                Looper.loop();
            }
        }.start();

    }

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
                    Message message = new Message();
                    message.what = 1;
                    mainHandler.sendMessage(message);
                    break;
            }
        }
    }
}
