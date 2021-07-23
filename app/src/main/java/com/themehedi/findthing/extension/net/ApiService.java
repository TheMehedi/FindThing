package com.themehedi.findthing.extension.net;

import com.themehedi.findthing.ui.activities.loginActivity.model.LoginDataModel;

public interface ApiService {

    void Login(ResponseCallback<LoginDataModel> responseCallback, String phone, String password);
}
