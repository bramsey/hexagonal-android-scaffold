package io.pivotal.hexagonalscaffold;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import io.pivotal.main.CoreModule;
import io.pivotal.main.ItemRepository;
import io.pivotal.main.ItemRepositoryTest;

@RunWith(RobolectricTestRunner.class)
public class AndroidItemRepositoryTest extends ItemRepositoryTest {

    @Override
    public ItemRepository getRepository() {
        Context context = RuntimeEnvironment.application;
        SharedPreferences sharedPreferences = context.getSharedPreferences("default", 0);
        return new AndroidItemRepository(sharedPreferences, new CoreModule().provideGson());
    }
}