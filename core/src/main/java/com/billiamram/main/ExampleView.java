package com.billiamram.main;

import com.billiamram.framework.View;

import java.util.List;

public interface ExampleView extends View {
    void loadItems(List<ExampleModel> exampleModels);
}
