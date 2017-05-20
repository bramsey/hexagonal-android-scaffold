package com.billiamram.hexagonalscaffold;

import android.content.Context;
import android.content.SharedPreferences;

import com.billiamram.main.CoreModule;
import com.billiamram.main.ExampleModelRepository;
import com.billiamram.main.ExampleModelRepositoryTest;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class AndroidExampleModelRepositoryTest extends ExampleModelRepositoryTest {

    @Override
    public ExampleModelRepository getRepository() {
        Context context = RuntimeEnvironment.application;
        SharedPreferences sharedPreferences = context.getSharedPreferences("default", 0);
        return new AndroidExampleModelRepository(sharedPreferences, new CoreModule().provideGson());
    }
}