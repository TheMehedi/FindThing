package com.themehedi.findthing.wastageProductActivity.presenters;

import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;

public interface WastagePresenterInterface {

    void onWastageResponse(WastageProductDataModel wastageProductDataModel);
    void onWastageError(String errMessage);
}
