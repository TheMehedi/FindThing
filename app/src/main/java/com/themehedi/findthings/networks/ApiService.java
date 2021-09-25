package com.themehedi.findthings.networks;

import com.themehedi.findthings.loginActivity.models.LoginDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.BannerDataModel;
import com.themehedi.findthings.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthings.registrationActivity.models.RegisterDataModel;
import com.themehedi.findthings.wastageProductActivity.models.datamodels.WastageProductDataModel;

public interface ApiService {

    void Login(ResponseCallback<LoginDataModel> responseCallback, String phone, String password);

    void Register(ResponseCallback<RegisterDataModel> responseCallback, String name, String email, String phone, String division_id, String district_id, String area_id, String password, String image);

    void Banner(ResponseCallback<BannerDataModel> bannerDataModelResponseCallback);

    void DealsProduct(ResponseCallback<DealsProductDataModel> dealsProductDataModelResponseCallback);

    void Wastage(ResponseCallback<WastageProductDataModel> wastageProductDataModelResponseCallback);
}
