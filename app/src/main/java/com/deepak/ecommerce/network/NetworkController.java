package com.deepak.ecommerce.network;

import com.deepak.ecommerce.EcommerceApp;
import com.deepak.ecommerce.listeners.IResponseListener;
import com.deepak.ecommerce.models.ApiResponse;
import javax.annotation.ParametersAreNonnullByDefault;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkController {
    public void getProducts(IResponseListener iResponseListener, String searchText, String apiKey) {
        EcommerceApp.getRetrofitAPI().getProducts().enqueue(new Callback<ApiResponse>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                iResponseListener.onResponse(response.body());
            }
            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                iResponseListener.onFailure(t);
            }
        });
    }
}