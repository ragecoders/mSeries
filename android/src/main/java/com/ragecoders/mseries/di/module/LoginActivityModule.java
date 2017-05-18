package com.ragecoders.mseries.di.module;

import com.ragecoders.datasource.api.FirebaseUtils;
import com.ragecoders.mseries.di.scope.ActivityScope;
import com.ragecoders.mseries.loginactivity.LoginActivityView;
import com.ragecoders.mseries.ui.activities.loginactivity.LoginActivity;
import com.ragecoders.mseries.ui.activities.loginactivity.LoginActivityViewHolder;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
@Module public class LoginActivityModule {
  private LoginActivity loginActivity;

  public LoginActivityModule(LoginActivity loginActivity) {
    this.loginActivity = loginActivity;
  }

  @Provides @ActivityScope LoginActivityView provideLoginActivityView() {
    return loginActivity;
  }

  @Provides @ActivityScope FirebaseUtils provideFirebaseUtils() {
    return new FirebaseUtils(loginActivity);
  }

  @Provides @ActivityScope LoginActivityViewHolder provideLoginActivityViewHolder() {
    return new LoginActivityViewHolder(loginActivity.getRootView());
  }
}
