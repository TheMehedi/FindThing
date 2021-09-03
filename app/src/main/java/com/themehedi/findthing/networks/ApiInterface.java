package com.themehedi.findthing.networks;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginDataModel> login(@Field("phone") String email, @Field("password") String password);
}