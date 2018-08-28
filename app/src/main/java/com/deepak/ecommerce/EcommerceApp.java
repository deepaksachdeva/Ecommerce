package com.deepak.ecommerce;

import android.app.Activity;
import android.app.Application;

import com.deepak.ecommerce.network.ApiHelper;
import com.deepak.ecommerce.di.component.DaggerAppComponent;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.deepak.ecommerce.utils.Constants.BASE_URL;

/**
 * Application class
 * Created by deepak sachdeva on 13/08/17.
 *
 * version 1.0
 */

public class EcommerceApp extends Application implements HasActivityInjector {

    private static ApiHelper retrofit = null;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    public static ApiHelper getRetrofitAPI() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//          set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(15, TimeUnit.MINUTES)
                    .writeTimeout(15, TimeUnit.MINUTES)
                    .connectTimeout(15, TimeUnit.MINUTES)
                    .retryOnConnectionFailure(true);
            if (BuildConfig.DEBUG)
                httpClient.addInterceptor(logging);
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .callFactory(httpClient.build())
                    .build()
                    .create(ApiHelper.class);
        }
        return retrofit;
    }
}