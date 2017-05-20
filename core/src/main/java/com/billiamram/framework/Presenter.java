package com.billiamram.framework;

public abstract class Presenter<T extends View> {
    protected T mView;

    public void loadView(T view) {
        mView = view;
        onViewLoaded(view);
    }

    protected abstract void onViewLoaded(T view);

    public void unloadView() {
        mView = null;
        onViewUnloaded();
    }

    protected abstract void onViewUnloaded();
}
