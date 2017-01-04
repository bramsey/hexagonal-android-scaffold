package io.pivotal.hexagonalscaffold;

import io.pivotal.main.ItemRepository;
import io.pivotal.main.ItemRepositoryTest;

public class AndroidItemRepositoryTest extends ItemRepositoryTest {

    @Override
    public ItemRepository getRepository() {
        return new AndroidItemRepository();
    }
}