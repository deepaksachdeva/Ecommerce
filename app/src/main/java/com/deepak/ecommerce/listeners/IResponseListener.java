package com.deepak.ecommerce.listeners;

import com.deepak.ecommerce.models.ApiResponse;

public interface IResponseListener {
    void onResponse(ApiResponse apiResponse);
    void onFailure(Throwable throwable);
}
