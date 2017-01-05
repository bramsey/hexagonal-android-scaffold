package io.pivotal.hexagonalscaffold;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.pivotal.main.Item;
import io.pivotal.main.ItemRepository;

public class AndroidItemRepository implements ItemRepository {

    private static final String ITEMS_KEY = "items";
    private final Gson mGson;

    private SharedPreferences mSharedPreferences;
    private Type mItemListType = new TypeToken<List<Item>>(){}.getType();

    public AndroidItemRepository(SharedPreferences sharedPreferences, Gson gson) {
        mSharedPreferences = sharedPreferences;
        mGson = gson;
    }

    @Override
    public List<Item> findAll() {
        String itemsJson = mSharedPreferences.getString(ITEMS_KEY, "[]");
        return mGson.fromJson(itemsJson, mItemListType);
    }

    @Override
    public void save(Item item) {
        List<Item> items = findAll();
        items.add(item);

        String itemsJson = mGson.toJson(items, mItemListType);

        mSharedPreferences.edit().putString(ITEMS_KEY, itemsJson).apply();
    }
}
