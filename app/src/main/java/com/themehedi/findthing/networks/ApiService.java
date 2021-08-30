package com.themehedi.findthing.networks;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;

public interface ApiService {

    void Login(ResponseCallback<LoginDataModel> responseCallback, String phone, String password);
}
