package io.pivotal.hexagonalscaffold;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.pivotal.main.GsonAdaptersItem;
import io.pivotal.main.ImmutableItem;
import io.pivotal.main.ItemRepository;
import io.pivotal.main.MainPresenter;

@Module
public class MainModule {

    @Singleton
    @Provides
    ItemRepository provideItemRepository(AndroidItemRepository androidItemRepository) {
        return androidItemRepository;
    }


    @Singleton
    @Provides
    MainPresenter provideMainPresenter(ItemRepository itemRepository) {
        itemRepository.save(ImmutableItem.builder()
                .name("name")
                .val("val")
                .build());
        return new MainPresenter(itemRepository);
    }

    @Singleton
    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new GsonAdaptersItem());
        return gsonBuilder.create();
    }

}
