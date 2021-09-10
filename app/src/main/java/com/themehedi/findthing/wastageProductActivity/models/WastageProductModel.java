package com.themehedi.findthing.wastageProductActivity.models;

import com.themehedi.findthing.networks.ApiService;
import com.themehedi.findthing.networks.NetworkCall;
import com.themehedi.findthing.networks.ResponseCallback;
import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;
import com.themehedi.findthing.wastageProductActivity.presenters.WastagePresenterInterface;

public class WastageProductModel {


    public static void wastage(WastagePresenterInterface wastagePresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Wastage(new ResponseCallback<WastageProductDataModel>() {
            @Override
            public void onSuccess(WastageProductDataModel data) {
                wastagePresenterInterface.onWastageResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                wastagePresenterInterface.onWastageError(errorMessage);
            }
        });
    }
}
