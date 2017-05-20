package com.billiamram.hexagonalscaffold

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val context: Context) {

    @Singleton
    @Provides
    internal fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("default", 0)
    }

}
