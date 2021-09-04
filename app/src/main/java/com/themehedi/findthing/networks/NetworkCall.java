package com.themehedi.findthing.networks;

import android.util.Log;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;
import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;

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
                if (response.code() == 200) {
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
}
