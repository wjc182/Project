package com.example.p7project.utils;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiRetrofit {

    @GET()
    Observable<ResponseBody> get(@Url String url);
}
