package com.themehedi.findthing.registrationActivity.presenters;


import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;

public interface RegisterPresenterInterface {
    void onRegisterResponse(RegisterDataModel data);
    void onRegisterError(String errMessage);
}
