package com.themehedi.findthings.networks;

import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;
import com.themehedi.findthings.loginActivity.models.LoginDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthings.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthings.wastageProductActivity.models.datamodels.WastageProductDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginDataModel> login(@Field("phone") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<RegisterDataModel> register(@Field("name") String name, @Field("email") String email, @Field("phone") String phone, @Field("division_id") String division_id, @Field("district_id") String district_id, @Field("area_id") String area_id, @Field("password") String password, @Field("image") String image);


    @GET("get/promotional/banner")
    Call<BannerDataModel> banner();

    @GET("get/deals/product/list")
    Call<DealsProductDataModel> dealsProduct();

    @GET("get/wastage/product/list")
    Call<WastageProductDataModel> wastageProduct();

    @GET("get/division")
    Call<DivisionDataModel> division();

    @GET("get/district")
    Call<DistrictDataModel> district();

    @GET("get/area")
    Call<AreaDataModel> area();
}
