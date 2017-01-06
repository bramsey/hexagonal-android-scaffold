package io.pivotal.hexagonalscaffold;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.pivotal.main.ExampleModelRepository;

@Module
public class AndroidAdaptersModule {

    @Singleton
    @Provides
    ExampleModelRepository provideItemRepository(SharedPreferences sharedPreferences,
                                                 Gson gson) {
        return new AndroidExampleModelRepository(sharedPreferences, gson);
    }

}
