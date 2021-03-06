package com.deepak.ecommerce.ui.splash;

import android.os.Handler;
import com.deepak.ecommerce.ui.base.BaseViewModel;
import com.deepak.ecommerce.utils.Constants;

/**
 * ViewModel of Splash
 * Created by deepak sachdeva on 13/08/17.
 *
 * version 1.0
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> implements Runnable {
    SplashViewModel() {
        super();
    }

    public void startSeeding() {
        Handler handler = new Handler();
        handler.postDelayed(this, Constants.SPLASH_TIME);
    }

    private void nextActivity() {
        getNavigator().openMainActivity();
    }

    @Override
    public void run() {
        nextActivity();
    }
}
