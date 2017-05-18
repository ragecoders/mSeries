package com.ragecoders.datasource.api;

import com.google.firebase.auth.FirebaseAuth;
import com.ragecoders.datasource.di.component.DaggerFirebaseUtilsComponent;
import com.ragecoders.datasource.di.component.FirebaseUtilsComponent;
import com.ragecoders.datasource.di.module.FirebaseUtilsModule;
import com.ragecoders.mseries.loginactivity.LoginActivityPresenter;
import com.ragecoders.mseries.loginactivity.LoginActivityView;
import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
public class FirebaseUtils {
  @Inject LoginActivityPresenter loginActivityPresenter;

  private FirebaseUtils instance;
  private LoginActivityView loginActivityView;
  private FirebaseAuth mAuth;

  @Inject public FirebaseUtils(LoginActivityView loginActivityView) {
    this.instance = this;
    this.mAuth = FirebaseAuth.getInstance();
    this.loginActivityView = loginActivityView;
    injectDependencies();
  }

  public LoginActivityView getLoginActivityView() {
    return loginActivityView;
  }

  private void injectDependencies() {
    FirebaseUtilsComponent firebaseUtilsComponent = DaggerFirebaseUtilsComponent.builder()
        .firebaseUtilsModule(new FirebaseUtilsModule(instance))
        .build();
    firebaseUtilsComponent.inject(this);
  }

  public void createUser(String email, String password) {
    mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(task -> loginActivityPresenter.login(task.isSuccessful()));
  }

  public void singUser(String email, String password) {
    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(task -> loginActivityPresenter.login(task.isSuccessful()));
  }
}
