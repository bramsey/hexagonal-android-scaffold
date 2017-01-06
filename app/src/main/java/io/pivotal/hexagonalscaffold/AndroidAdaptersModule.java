package io.pivotal.hexagonalscaffold;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.pivotal.main.ItemRepository;

@Module
public class AndroidAdaptersModule {

    @Singleton
    @Provides
    ItemRepository provideItemRepository(SharedPreferences sharedPreferences,
                                         Gson gson) {
        return new AndroidItemRepository(sharedPreferences, gson);
    }

}
