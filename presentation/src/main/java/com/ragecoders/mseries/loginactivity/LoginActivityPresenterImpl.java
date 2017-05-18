package com.ragecoders.mseries.loginactivity;

import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
public class LoginActivityPresenterImpl implements LoginActivityPresenter {

  @Inject LoginActivityView view;

  @Inject public LoginActivityPresenterImpl() {
  }

  @Override public void login(boolean isSuccessful) {
    if (isSuccessful) {
      view.launchHomeActivity();
    } else {
      view.setError("Error");
    }
  }
}
