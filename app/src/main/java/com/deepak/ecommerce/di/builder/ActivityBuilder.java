package com.deepak.ecommerce.di.builder;

import com.deepak.ecommerce.ui.splash.SplashActivity;
import com.deepak.ecommerce.ui.splash.SplashActivityModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();
}
