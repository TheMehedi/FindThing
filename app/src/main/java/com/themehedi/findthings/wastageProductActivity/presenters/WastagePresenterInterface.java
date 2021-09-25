package com.themehedi.findthings.wastageProductActivity.presenters;

import com.themehedi.findthings.wastageProductActivity.models.datamodels.WastageProductDataModel;

public interface WastagePresenterInterface {

    void onWastageResponse(WastageProductDataModel wastageProductDataModel);
    void onWastageError(String errMessage);
}
