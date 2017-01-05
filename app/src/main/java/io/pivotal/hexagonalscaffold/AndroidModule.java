package io.pivotal.hexagonalscaffold;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

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
    AndroidItemRepository provideAndroidItemRepository(SharedPreferences sharedPreferences, Gson gson) {
        return new AndroidItemRepository(sharedPreferences, gson);
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("default", 0);
    }

}
