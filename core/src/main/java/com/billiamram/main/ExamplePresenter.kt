package com.billiamram.main

import com.billiamram.framework.Presenter

class ExamplePresenter(private val mExampleModelRepository: ExampleModelRepository) : Presenter<ExampleView>() {

    override fun onViewLoaded(view: ExampleView) {
        view.loadItems(mExampleModelRepository.findAll())
    }

    override fun onViewUnloaded() {}
}
