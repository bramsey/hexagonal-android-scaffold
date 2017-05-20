package com.billiamram.main;

import java.util.List;

public interface ExampleModelRepository {
    public List<ExampleModel> findAll();

    public void save(ExampleModel exampleModel);
}
