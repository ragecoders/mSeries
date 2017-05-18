package com.ragecoders.mseries.di.component;

import com.ragecoders.mseries.di.module.LoginActivityModule;
import com.ragecoders.mseries.di.scope.ActivityScope;
import com.ragecoders.mseries.ui.activities.loginactivity.LoginActivity;
import dagger.Component;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
@ActivityScope @Component(modules = LoginActivityModule.class)
public interface LoginActivityComponent {
  void inject(LoginActivity loginActivity);
}
