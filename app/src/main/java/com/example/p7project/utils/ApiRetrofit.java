package com.example.p7project.utils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiRetrofit {

    @GET()
    Observable<ResponseBody> get(@Url String url);


    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> pos(@Url String string,@FieldMap HashMap<String,String> map);

    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> posTaken(@Url String string,@HeaderMap HashMap<String,String> heads);
}
