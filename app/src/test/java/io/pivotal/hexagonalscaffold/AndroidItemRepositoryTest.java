package io.pivotal.hexagonalscaffold;

import android.content.SharedPreferences;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import io.pivotal.main.ItemRepository;
import io.pivotal.main.ItemRepositoryTest;

@RunWith(RobolectricTestRunner.class)
public class AndroidItemRepositoryTest extends ItemRepositoryTest {

    @Override
    public ItemRepository getRepository() {
        SharedPreferences sharedPreferences = RuntimeEnvironment.application
                .getSharedPreferences("default", 0);
        return new AndroidItemRepository(sharedPreferences, new MainModule().provideGson());
    }
}