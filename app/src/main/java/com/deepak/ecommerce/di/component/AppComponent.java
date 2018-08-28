package com.deepak.ecommerce.di.component;

import android.app.Application;

import com.deepak.ecommerce.EcommerceApp;
import com.deepak.ecommerce.di.builder.ActivityBuilder;
import com.deepak.ecommerce.di.module.AppModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(EcommerceApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
