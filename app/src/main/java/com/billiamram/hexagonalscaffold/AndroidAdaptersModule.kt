package com.billiamram.hexagonalscaffold

import android.content.SharedPreferences
import com.billiamram.main.ExampleModelRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidAdaptersModule {

    @Singleton
    @Provides
    internal fun provideItemRepository(sharedPreferences: SharedPreferences,
                                       gson: Gson): ExampleModelRepository {
        return AndroidExampleModelRepository(sharedPreferences, gson)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }

}
