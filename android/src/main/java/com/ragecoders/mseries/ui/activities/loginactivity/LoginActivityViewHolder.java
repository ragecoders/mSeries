package com.ragecoders.mseries.ui.activities.loginactivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ragecoders.mseries.R;
import com.ragecoders.mseries.ui.BasicViewHolder;
import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
public class LoginActivityViewHolder implements BasicViewHolder {
  @BindView(R.id.etEmail) EditText etEmail;
  @BindView(R.id.etPassword) EditText etPassword;
  @BindView(R.id.btLogin) Button btLogin;

  private Unbinder unbinder;

  @Inject public LoginActivityViewHolder(View view) {
    unbinder = ButterKnife.bind(this, view);
  }

  @Override public void unbind() {
    unbinder.unbind();
  }
}
