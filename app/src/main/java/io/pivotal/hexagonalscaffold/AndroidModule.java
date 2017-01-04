package io.pivotal.hexagonalscaffold;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    private Context context;

    public AndroidModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    AndroidItemRepository provideAndroidItemRepository(SharedPreferences sharedPreferences) {
        return new AndroidItemRepository(sharedPreferences);
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("default", 0);
    }

}
