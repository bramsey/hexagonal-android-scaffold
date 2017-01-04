package io.pivotal.main;

public class InMemoryItemRepositoryTest extends ItemRepositoryTest {

    @Override
    public ItemRepository getRepository() {
        return new InMemoryItemRepository();
    }
}