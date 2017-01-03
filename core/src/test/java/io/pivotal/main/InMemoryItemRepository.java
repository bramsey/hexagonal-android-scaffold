package io.pivotal.main;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemRepository implements ItemRepository {

    private List<Item> mItems = new ArrayList<>();

    @Override
    public List<Item> findAll() {
        return mItems;
    }

    @Override
    public void save(Item item) {
        mItems.add(item);
    }
}
