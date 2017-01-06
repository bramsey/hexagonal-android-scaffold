package io.pivotal.main;

import java.util.ArrayList;
import java.util.List;

public class InMemoryExampleModelRepository implements ExampleModelRepository {

    private List<ExampleModel> mExampleModels = new ArrayList<>();

    @Override
    public List<ExampleModel> findAll() {
        return mExampleModels;
    }

    @Override
    public void save(ExampleModel exampleModel) {
        mExampleModels.add(exampleModel);
    }
}
