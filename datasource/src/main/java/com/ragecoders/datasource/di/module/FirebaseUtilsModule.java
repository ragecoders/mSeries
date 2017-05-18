package com.ragecoders.datasource.di.module;

import com.ragecoders.datasource.api.FirebaseUtils;
import com.ragecoders.datasource.di.scope.ActivityScope;
import com.ragecoders.mseries.loginactivity.LoginActivityPresenter;
import com.ragecoders.mseries.loginactivity.LoginActivityPresenterImpl;
import com.ragecoders.mseries.loginactivity.LoginActivityView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
@Module public class FirebaseUtilsModule {
  private FirebaseUtils firebaseUtils;

  public FirebaseUtilsModule(FirebaseUtils firebaseUtils) {
    this.firebaseUtils = firebaseUtils;
  }

  @Provides @ActivityScope LoginActivityPresenter provideLoginActivityPresenter(
      LoginActivityPresenterImpl presenter) {
    return presenter;
  }

  @Provides @ActivityScope LoginActivityView provideLoginActivityView() {
    return firebaseUtils.getLoginActivityView();
  }
}
