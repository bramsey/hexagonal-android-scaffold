package io.pivotal.hexagonalscaffold;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import io.pivotal.main.CoreModule;
import io.pivotal.main.ExampleModelRepository;
import io.pivotal.main.ExampleModelRepositoryTest;

@RunWith(RobolectricTestRunner.class)
public class AndroidExampleModelRepositoryTest extends ExampleModelRepositoryTest {

    @Override
    public ExampleModelRepository getRepository() {
        Context context = RuntimeEnvironment.application;
        SharedPreferences sharedPreferences = context.getSharedPreferences("default", 0);
        return new AndroidExampleModelRepository(sharedPreferences, new CoreModule().provideGson());
    }
}