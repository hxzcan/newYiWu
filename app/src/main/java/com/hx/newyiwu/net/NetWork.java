package com.hx.newyiwu.net;


import com.hx.newyiwu.base.GlobalVar;
import com.hx.newyiwu.net.Api.LoginApi;


import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:rxjava和retrofi
 * 接口的初始化
 */

public class NetWork {
    public static OkHttpClient okHttpClient=new OkHttpClient();
    public static Converter.Factory gsonConverterFactory=GsonConverterFactory.create();
    public static CallAdapter.Factory rxJavaCallAdapterFactory= RxJavaCallAdapterFactory.create();

    public static LoginApi loginApi;

    public static LoginApi getLoginApi(){


        if (loginApi==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(GlobalVar.LOGIN_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            loginApi=retrofit.create(LoginApi.class);
        }
        return  loginApi;
    }
}
