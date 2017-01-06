package io.pivotal.main;

import java.util.List;

import io.pivotal.framework.View;

public interface ExampleView extends View {
    void loadItems(List<ExampleModel> exampleModels);
}
