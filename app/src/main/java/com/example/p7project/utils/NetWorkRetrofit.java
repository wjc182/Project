package com.example.p7project.utils;



import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class NetWorkRetrofit {
    private static volatile NetWorkRetrofit nextRetrofit;
    private final Retrofit retrofit;

    public NetWorkRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //单例模式
    public static NetWorkRetrofit getInstance(){
        if(nextRetrofit==null){
            synchronized (NetWorkRetrofit.class){
                nextRetrofit=new NetWorkRetrofit();
            }
        }
        return nextRetrofit;
    }


    public <T> void iModel(String url, CallBack<T> callback) {

        retrofit.create(ApiRetrofit.class)
                .get(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            callback.OnSuccess(json);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.OnFail("网络错误："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public <T> void iModelLog(String string, HashMap<String, String> map,CallBack<T> callback) {

        retrofit.create(ApiRetrofit.class)
                .pos(string,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            callback.OnSuccess(json);



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.OnFail("网络错误："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public <T> void refreshtoken(String string, HashMap<String, String> heads,CallBack<T> callback) {

        retrofit.create(ApiRetrofit.class)
                .posTaken(string,heads)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            callback.OnSuccess(json);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.OnFail("网络错误："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
