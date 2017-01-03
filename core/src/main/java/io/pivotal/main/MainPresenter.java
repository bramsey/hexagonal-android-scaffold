package io.pivotal.main;

import io.pivotal.framework.Presenter;

public class MainPresenter extends Presenter<MainView> {

    private ItemRepository mItemRepository;

    public MainPresenter(ItemRepository itemRepository) {
        mItemRepository = itemRepository;
    }

    @Override
    protected void onViewLoaded(MainView view) {
        view.loadItems(mItemRepository.findAll());
    }

    @Override
    protected void onViewUnloaded() {
    }
}
