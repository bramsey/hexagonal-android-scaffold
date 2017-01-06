package io.pivotal.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(ItemRepository itemRepository) {
        return new MainPresenter(itemRepository);
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new GsonAdaptersItem());
        return gsonBuilder.create();
    }

}
