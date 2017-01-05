package io.pivotal.main;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public interface Item {
    String getName();

    String getVal();
}
