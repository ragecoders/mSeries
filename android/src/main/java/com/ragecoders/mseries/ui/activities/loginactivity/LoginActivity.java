package com.ragecoders.mseries.ui.activities.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.ragecoders.datasource.api.FirebaseUtils;
import com.ragecoders.mseries.R;
import com.ragecoders.mseries.di.component.DaggerLoginActivityComponent;
import com.ragecoders.mseries.di.component.LoginActivityComponent;
import com.ragecoders.mseries.di.module.LoginActivityModule;
import com.ragecoders.mseries.loginactivity.LoginActivityView;
import com.ragecoders.mseries.ui.activities.BaseActivity;
import com.ragecoders.mseries.ui.activities.homeactivity.HomeActivity;
import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
public class LoginActivity extends BaseActivity implements LoginActivityView {

  @Inject LoginActivityViewHolder viewHolder;
  @Inject FirebaseUtils firebaseUtils;

  @Inject public LoginActivity newInstance() {
    return new LoginActivity();
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    injectDependencies();
    initializeView();
    hookEvents();
  }

  private void initializeView() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void injectDependencies() {
    LoginActivityComponent loginActivityComponent = DaggerLoginActivityComponent.builder()
        .loginActivityModule(new LoginActivityModule(this))
        .build();
    loginActivityComponent.inject(this);
  }

  private void hookEvents() {
    viewHolder.btLogin.setOnClickListener(v -> {
      firebaseUtils.singUser(viewHolder.etEmail.getText().toString(),
          viewHolder.etPassword.getText().toString());
    });
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    viewHolder.unbind();
  }

  @Override public void setError(String text) {
    Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();
  }

  @Override public void launchHomeActivity() {
    Intent intent = new Intent(this, HomeActivity.class);
    startActivity(intent);
  }
}
