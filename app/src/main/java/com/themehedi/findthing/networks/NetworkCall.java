package com.themehedi.findthing.networks;

import android.util.Log;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements ApiService{

    private final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    private void apiError(String errorMessage) {
        Log.i("ApiError", "ApiError: " + errorMessage);
    }

    @Override
    public void Login(ResponseCallback<LoginDataModel> responseCallback, String phone, String password) {


        Call<LoginDataModel> call = apiInterface.login(phone, password);
        call.enqueue(new Callback<LoginDataModel>() {
            @Override
            public void onResponse(Call<LoginDataModel> call, Response<LoginDataModel> response) {
                if (response.code() == 200) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void Register(ResponseCallback<RegisterDataModel> responseCallback, String name, String email, String phone, String division_id, String district_id, String area_id, String password, String image) {


        Call<RegisterDataModel> call = apiInterface.register(name, email, phone, division_id, district_id, area_id, password, image);
        call.enqueue(new Callback<RegisterDataModel>() {
            @Override
            public void onResponse(Call<RegisterDataModel> call, Response<RegisterDataModel> response) {
                if (response.code() == 201) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisterDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void Banner(ResponseCallback<BannerDataModel> responseCallback) {


        Call<BannerDataModel> call = apiInterface.banner();
        call.enqueue(new Callback<BannerDataModel>() {
            @Override
            public void onResponse(Call<BannerDataModel> call, Response<BannerDataModel> response) {
                if (response.code() == 200) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<BannerDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void DealsProduct(ResponseCallback<DealsProductDataModel> responseCallback) {


        Call<DealsProductDataModel> call = apiInterface.dealsProduct();
        call.enqueue(new Callback<DealsProductDataModel>() {
            @Override
            public void onResponse(Call<DealsProductDataModel> call, Response<DealsProductDataModel> response) {
                if (response.code() == 200) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<DealsProductDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }


    @Override
    public void Wastage(ResponseCallback<WastageProductDataModel> responseCallback) {


        Call<WastageProductDataModel> call = apiInterface.wastageProduct();
        call.enqueue(new Callback<WastageProductDataModel>() {
            @Override
            public void onResponse(Call<WastageProductDataModel> call, Response<WastageProductDataModel> response) {
                if (response.code() == 200) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<WastageProductDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }
}
