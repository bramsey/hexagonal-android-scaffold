package io.pivotal.hexagonalscaffold;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.pivotal.main.ExampleModel;
import io.pivotal.main.ExampleModelRepository;

public class AndroidExampleModelRepository implements ExampleModelRepository {

    private static final String MODELS_KEY = "models";
    private final Gson mGson;

    private SharedPreferences mSharedPreferences;
    private Type mModelListType = new TypeToken<List<ExampleModel>>() {
    }.getType();

    public AndroidExampleModelRepository(SharedPreferences sharedPreferences, Gson gson) {
        mSharedPreferences = sharedPreferences;
        mGson = gson;
    }

    @Override
    public List<ExampleModel> findAll() {
        String modelsJson = mSharedPreferences.getString(MODELS_KEY, "[]");
        return mGson.fromJson(modelsJson, mModelListType);
    }

    @Override
    public void save(ExampleModel exampleModel) {
        List<ExampleModel> exampleModels = findAll();
        exampleModels.add(exampleModel);

        String modelsJson = mGson.toJson(exampleModels, mModelListType);

        mSharedPreferences.edit().putString(MODELS_KEY, modelsJson).apply();
    }
}
