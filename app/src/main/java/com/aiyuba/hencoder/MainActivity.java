package com.aiyuba.hencoder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aiyuba.hencoder._7textmeasure.CustomCircleProgressBar;
import com.aiyuba.hencoder.retrofit.Api;
import com.aiyuba.retrofitokhttp.IAdditionService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends AppCompatActivity {

    IAdditionService mService;
    TextView aidl;

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IAdditionService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__7);
        Button btn = findViewById(R.id.btn);
        aidl = findViewById(R.id.aidl);
        CustomCircleProgressBar progress = findViewById(R.id.progress);
        progress.setProgressGroup(new int[]{30,60,10,80,30});
        progress.setProgressStr(new String[]{"单词单词","听力","阅读","口语","写作"});
        Intent intent = new Intent();
        intent.setAction("com.maomao.add");
        intent.setPackage("com.aiyuba.retrofitokhttp");//fix Service Intent must be explicit
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidl.setText("相加的结果"+mService.add(200,400));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //retrofit源码查看
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://square.github.io/")
//                .build();
//        Api api = retrofit.create(Api.class);
//
//        Call<ResponseBody> call = api.getIntro("retrofit");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                System.out.println("success");
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                System.out.println("failed");
//            }
//        });
//
//        //okhttp源码查看
//        OkHttpClient client = new OkHttpClient();
//        okhttp3.Call call1 = client.newCall(new Request.Builder().url("https://square.github.io/").build());
//        call1.enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                System.out.println("failed");
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//                System.out.println("success");
//            }
//        });
    }
}
