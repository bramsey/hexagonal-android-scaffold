package io.pivotal.main;

import java.util.List;

import io.pivotal.framework.View;

public interface MainView extends View {
    void loadItems(List<Item> items);
}
