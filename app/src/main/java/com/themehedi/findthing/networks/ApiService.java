package com.themehedi.findthing.networks;

import com.themehedi.findthing.loginActivity.models.LoginDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthing.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthing.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;

public interface ApiService {

    void Login(ResponseCallback<LoginDataModel> responseCallback, String phone, String password);

    void Register(ResponseCallback<RegisterDataModel> responseCallback, String name, String email, String phone, String division_id, String district_id, String area_id, String password, String image);

    void Banner(ResponseCallback<BannerDataModel> bannerDataModelResponseCallback);

    void DealsProduct(ResponseCallback<DealsProductDataModel> dealsProductDataModelResponseCallback);

    void Wastage(ResponseCallback<WastageProductDataModel> wastageProductDataModelResponseCallback);
}
