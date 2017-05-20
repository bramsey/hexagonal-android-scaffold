package com.billiamram.main

class InMemoryExampleModelRepositoryTest : ExampleModelRepositoryTest() {
    override val repository: ExampleModelRepository get() = InMemoryExampleModelRepository()

}