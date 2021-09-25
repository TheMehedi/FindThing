package com.themehedi.findthings.registrationActivity.presenters;


import com.themehedi.findthings.registrationActivity.models.RegisterDataModel;

public interface RegisterPresenterInterface {
    void onRegisterResponse(RegisterDataModel data);
    void onRegisterError(String errMessage);
}
