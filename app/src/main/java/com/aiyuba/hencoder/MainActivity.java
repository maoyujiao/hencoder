package com.aiyuba.hencoder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aiyuba.hencoder.retrofit.Api;

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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__7);
        try {
            InputStream inputStream = new FileInputStream("./001-002.lrc");
            try {
                Reader reader = new InputStreamReader(inputStream,"GBK");
                try {
                    System.out.println("maoyujiao："+reader.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
