package com.themehedi.findthing.networks;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;
import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginDataModel> login(@Field("phone") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<RegisterDataModel> register(@Field("name") String name, @Field("email") String email, @Field("phone") String phone, @Field("division_id") String division_id, @Field("district_id") String district_id, @Field("area_id") String area_id, @Field("password") String password, @Field("image") String image);
}
