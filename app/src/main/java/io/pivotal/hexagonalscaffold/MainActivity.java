package io.pivotal.hexagonalscaffold;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import io.pivotal.main.Item;
import io.pivotal.main.MainPresenter;
import io.pivotal.main.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Injector.get(this).inject(this);

        mMainPresenter.loadView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.unloadView();
    }

    @Override
    public void loadItems(List<Item> items) {
        for (Item item : items) {
            String text = String.format(Locale.US, "%s: %s", item.getName(), item.getVal());
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
