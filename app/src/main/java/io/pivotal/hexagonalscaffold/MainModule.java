package io.pivotal.hexagonalscaffold;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.pivotal.main.Item;
import io.pivotal.main.ItemRepository;
import io.pivotal.main.MainPresenter;

@Module
public class MainModule {

    @Singleton
    @Provides
    ItemRepository provideItemRepository() {
        return new AndroidItemRepository();
    }

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(ItemRepository itemRepository) {
        itemRepository.save(new Item("default name", "default val"));
        itemRepository.save(new Item("other name", "other val"));
        return new MainPresenter(itemRepository);
    }
}
