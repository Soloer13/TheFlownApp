package com.theflown.theflownapp.data.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    //public static final String Base_Url = "http://192.168.8.200:81/flown_app/api/";
    //public static final String Base_Url = "http://192.168.43.142:80/flown_app/api/";
//    public static final String Base_Url="http://192.168.8.106:80/flown_app/api/";

    public static final String Base_Url="https://soloer13.000webhostapp.com/flown_app/api/";

//    public static final String Base_Url="http://192.168.1.105:80/flown_app/api/";

    private static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd hh:mm:ss")
            .setLenient()
            .create();

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit;
    }

//    public static Retrofit getApiClient(){
//        return getClient();
//    }
//
//    public static synchronized Retrofit getClient() {
//        if (retrofit == null) {
//
//            int timeOut = 20;
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .connectTimeout(timeOut, TimeUnit.SECONDS)
//                    .writeTimeout(timeOut * 3, TimeUnit.SECONDS)
//                    .readTimeout(timeOut * 3, TimeUnit.SECONDS)
//                    .build();
//
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Base_Url)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .client(client)
//                    .build();
//        }
//        return retrofit;
//    }

}
