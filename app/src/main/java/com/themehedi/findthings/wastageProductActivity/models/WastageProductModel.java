package com.themehedi.findthings.wastageProductActivity.models;

import com.themehedi.findthings.networks.ApiService;
import com.themehedi.findthings.networks.NetworkCall;
import com.themehedi.findthings.networks.ResponseCallback;
import com.themehedi.findthings.wastageProductActivity.models.datamodels.WastageProductDataModel;
import com.themehedi.findthings.wastageProductActivity.presenters.WastagePresenterInterface;

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
