package com.themehedi.findthing.registrationActivity.models;


import com.themehedi.findthing.networks.ApiService;
import com.themehedi.findthing.networks.NetworkCall;
import com.themehedi.findthing.networks.ResponseCallback;
import com.themehedi.findthing.registrationActivity.presenters.RegisterPresenterInterface;

public class RegisterModel {

    public static void Register(String name, String email, String phone, String division_id, String district_id, String area_id, String password, String image, RegisterPresenterInterface registerPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Register(new ResponseCallback<RegisterDataModel>() {
            @Override
            public void onSuccess(RegisterDataModel data) {
                registerPresenterInterface.onRegisterResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                registerPresenterInterface.onRegisterError(errorMessage);
            }
        },name, email, phone, division_id, district_id, area_id, password, image);
    }

}
