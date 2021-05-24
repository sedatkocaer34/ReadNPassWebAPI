package com.example.readnpass.Interfaces;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;
    private static String Base_Url= APIUrl.BASE_URL;
    public static Retrofit getClient() {
        if (retrofit == null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                     .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
