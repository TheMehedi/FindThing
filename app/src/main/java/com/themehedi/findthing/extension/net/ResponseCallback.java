package com.themehedi.findthing.extension.net;

public interface ResponseCallback <T> {

    void onSuccess(T data);
    void onError(String errorMessage);

}
