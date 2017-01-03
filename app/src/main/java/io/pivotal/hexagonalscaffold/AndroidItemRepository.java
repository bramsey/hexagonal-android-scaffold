package io.pivotal.hexagonalscaffold;

import java.util.ArrayList;
import java.util.List;

import io.pivotal.main.Item;
import io.pivotal.main.ItemRepository;

public class AndroidItemRepository implements ItemRepository {

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
