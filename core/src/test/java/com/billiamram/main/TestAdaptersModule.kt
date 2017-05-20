package com.billiamram.main

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestAdaptersModule {

    @Provides
    @Singleton
    internal fun provideItemRepository(): ExampleModelRepository {
        return InMemoryExampleModelRepository()
    }
}
