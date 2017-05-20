package com.billiamram.main

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideMainPresenter(exampleModelRepository: ExampleModelRepository): ExamplePresenter {
        return ExamplePresenter(exampleModelRepository)
    }

}
