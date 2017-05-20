package com.billiamram.main;

public class InMemoryExampleModelRepositoryTest extends ExampleModelRepositoryTest {

    @Override
    public ExampleModelRepository getRepository() {
        return new InMemoryExampleModelRepository();
    }
}