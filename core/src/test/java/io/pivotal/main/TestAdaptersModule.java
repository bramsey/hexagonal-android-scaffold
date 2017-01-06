package io.pivotal.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestAdaptersModule {

    @Provides
    @Singleton
    ItemRepository provideItemRepository() {
        return new InMemoryItemRepository();
    }
}
