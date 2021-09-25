package com.themehedi.findthings.networks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.themehedi.findthings.BuildConfig;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = BuildConfig.BASE_URL;
    private static Retrofit retrofit = null;

    private static final Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    public static synchronized Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }


}
