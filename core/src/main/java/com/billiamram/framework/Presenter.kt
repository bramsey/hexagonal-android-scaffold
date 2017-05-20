package com.billiamram.framework

abstract class Presenter<T : View> {
    protected var mView: T? = null

    fun loadView(view: T) {
        mView = view
        onViewLoaded(view)
    }

    protected abstract fun onViewLoaded(view: T)

    fun unloadView() {
        mView = null
        onViewUnloaded()
    }

    protected abstract fun onViewUnloaded()
}
