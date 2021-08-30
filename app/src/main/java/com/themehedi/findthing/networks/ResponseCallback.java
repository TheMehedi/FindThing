package com.themehedi.findthing.networks;

public interface ResponseCallback <T> {

    void onSuccess(T data);
    void onError(String errorMessage);

}
