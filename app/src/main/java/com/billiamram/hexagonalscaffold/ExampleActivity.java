package com.billiamram.hexagonalscaffold;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.billiamram.main.ExampleModel;
import com.billiamram.main.ExamplePresenter;
import com.billiamram.main.ExampleView;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class ExampleActivity extends AppCompatActivity implements ExampleView {

    @Inject ExamplePresenter mExamplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Injector.get(this).inject(this);

        mExamplePresenter.loadView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExamplePresenter.unloadView();
    }

    @Override
    public void loadItems(List<ExampleModel> exampleModels) {
        for (ExampleModel exampleModel : exampleModels) {
            String text = String.format(Locale.US, "%s: %s", exampleModel.getName(), exampleModel.getVal());
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
