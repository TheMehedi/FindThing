package com.themehedi.findthings.findPeopleActivity.models;

import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;
import com.themehedi.findthings.findPeopleActivity.presenters.FindPresenterInterface;
import com.themehedi.findthings.networks.ApiService;
import com.themehedi.findthings.networks.NetworkCall;
import com.themehedi.findthings.networks.ResponseCallback;

public class FindPeopleModel {

    public static void division(FindPresenterInterface findPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Division(new ResponseCallback<DivisionDataModel>() {
            @Override
            public void onSuccess(DivisionDataModel data) {
                findPresenterInterface.onDivisionResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                findPresenterInterface.onDivisionError(errorMessage);
            }
        });
    }

    public static void district(FindPresenterInterface findPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.District(new ResponseCallback<DistrictDataModel>() {
            @Override
            public void onSuccess(DistrictDataModel data) {
                findPresenterInterface.onDistrictResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                findPresenterInterface.onDistrictError(errorMessage);
            }
        });
    }

    public static void area(FindPresenterInterface findPresenterInterface) {
        ApiService apiService = new NetworkCall();
        apiService.Area(new ResponseCallback<AreaDataModel>() {
            @Override
            public void onSuccess(AreaDataModel data) {
                findPresenterInterface.onAreaResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                findPresenterInterface.onAreaError(errorMessage);
            }
        });
    }
}
