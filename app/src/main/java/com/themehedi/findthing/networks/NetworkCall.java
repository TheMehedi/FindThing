package com.themehedi.findthing.networks;

import android.util.Log;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;

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
}
