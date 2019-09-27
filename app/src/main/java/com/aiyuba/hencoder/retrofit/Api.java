package com.aiyuba.hencoder.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by maoyujiao on 2019/9/23.
 */

public interface Api {
    @GET("path/{type}/")
    Call<ResponseBody> getIntro(@Path("type") String type);
}
