package com.ragecoders.mseries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ragecoders.mseries.di.component.BaseActivityComponent;
import com.ragecoders.mseries.di.component.DaggerBaseActivityComponent;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 17/05/17
 */
public abstract class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
  }

  private void injectDependencies() {
    BaseActivityComponent baseActivityComponent = DaggerBaseActivityComponent.builder().build();
    baseActivityComponent.inject(this);
  }
}
