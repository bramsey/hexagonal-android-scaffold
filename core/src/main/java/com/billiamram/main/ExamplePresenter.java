package com.billiamram.main;

import com.billiamram.framework.Presenter;

public class ExamplePresenter extends Presenter<ExampleView> {

    private ExampleModelRepository mExampleModelRepository;

    public ExamplePresenter(ExampleModelRepository exampleModelRepository) {
        mExampleModelRepository = exampleModelRepository;
    }

    @Override
    protected void onViewLoaded(ExampleView view) {
        view.loadItems(mExampleModelRepository.findAll());
    }

    @Override
    protected void onViewUnloaded() {
    }
}
