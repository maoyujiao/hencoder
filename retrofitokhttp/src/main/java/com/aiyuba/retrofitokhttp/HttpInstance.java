package com.aiyuba.retrofitokhttp;

import retrofit2.Retrofit;

/**
 * Created by maoyujiao on 2019/10/18.
 * 设计模式：动态代理 适配器模式 工厂模式
 *
 *
 */

public class HttpInstance {
    private static HttpInstance httpInstance;
    private static RetrofitApi api;

    private HttpInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(null)
                .addConverterFactory(null)
                .build();
        api = retrofit.create(RetrofitApi.class);
    }

    public static RetrofitApi getInstance(){
            if(httpInstance == null){
                synchronized (HttpInstance.class){
                    if(httpInstance == null) {
                        httpInstance = new HttpInstance();
                    }
                }
        }
        return api;
    }
}
