package io.pivotal.main;

import java.util.List;

public interface ItemRepository {
    public List<Item> findAll();

    public void save(Item item);
}
