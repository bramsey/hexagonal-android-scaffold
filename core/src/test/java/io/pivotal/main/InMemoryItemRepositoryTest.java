package io.pivotal.main;

public class InMemoryItemRepositoryTest extends ItemRepositoryTest {

    @Override
    ItemRepository getRepository() {
        return new InMemoryItemRepository();
    }
}