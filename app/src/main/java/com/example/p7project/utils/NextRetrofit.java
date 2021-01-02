package com.example.p7project.utils;



import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class NextRetrofit implements Imodel {
    private static volatile NextRetrofit nextRetrofit;
    private final Retrofit retrofit;
    private final Retrofit retrofit1;

    public NextRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit1 = new Retrofit.Builder()
                .baseUrl(URL.fenUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    //单例模式
    public static NextRetrofit getInstance(){
        if(nextRetrofit==null){
            synchronized (NextRetrofit.class){
                nextRetrofit=new NextRetrofit();
            }
        }

        return nextRetrofit;
    }

    @Override
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

        retrofit1.create(ApiRetrofit.class)
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
}
