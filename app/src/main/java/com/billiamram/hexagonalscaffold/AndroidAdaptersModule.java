package com.billiamram.hexagonalscaffold;

import android.content.SharedPreferences;

import com.billiamram.main.ExampleModelRepository;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidAdaptersModule {

    @Singleton
    @Provides
    ExampleModelRepository provideItemRepository(SharedPreferences sharedPreferences,
                                                 Gson gson) {
        return new AndroidExampleModelRepository(sharedPreferences, gson);
    }

}
