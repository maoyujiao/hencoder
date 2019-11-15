package com.aiyuba.retrofitokhttp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by maoyujiao on 2019/10/18.
 */

public interface RetrofitApi {

    @GET("users/{username}")
    Call<ResponseBody> getUserInfo(@Path("username") String user);
}
