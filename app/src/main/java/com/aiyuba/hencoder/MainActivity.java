package com.aiyuba.hencoder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aiyuba.hencoder.retrofit.Api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
