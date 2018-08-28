package com.deepak.ecommerce.network;

import com.deepak.ecommerce.models.ApiResponse;
import com.deepak.ecommerce.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiHelper {

    @GET(Constants.SLASH + Constants.JSON)
    Call<ApiResponse> getProducts();
}