package com.billiamram.main;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public interface ExampleModel {
    String getName();

    String getVal();
}
