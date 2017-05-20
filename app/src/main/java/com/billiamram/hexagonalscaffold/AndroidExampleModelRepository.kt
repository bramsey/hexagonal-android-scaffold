package com.billiamram.hexagonalscaffold

import android.content.SharedPreferences
import com.billiamram.main.ExampleModel
import com.billiamram.main.ExampleModelRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AndroidExampleModelRepository(private val mSharedPreferences: SharedPreferences, private val mGson: Gson) : ExampleModelRepository {
    private val mModelListType = object : TypeToken<List<ExampleModel>>() {}.type

    override fun findAll(): List<ExampleModel> {
        val modelsJson = mSharedPreferences.getString(MODELS_KEY, "[]")
        return mGson.fromJson<List<ExampleModel>>(modelsJson, mModelListType)
    }

    override fun save(exampleModel: ExampleModel) {
        val modelsJson = mGson.toJson(findAll().plus(exampleModel), mModelListType)

        mSharedPreferences.edit().putString(MODELS_KEY, modelsJson).apply()
    }

    companion object {
        private val MODELS_KEY = "models"
    }
}
