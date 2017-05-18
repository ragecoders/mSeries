package com.ragecoders.mseries.di.component;

import com.ragecoders.mseries.di.module.HomeActivityModule;
import com.ragecoders.mseries.di.scope.ActivityScope;
import com.ragecoders.mseries.ui.activities.homeactivity.HomeActivity;
import dagger.Component;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 17/05/17
 */
@ActivityScope @Component(modules = HomeActivityModule.class)
public interface HomeActivityComponent {
  void inject(HomeActivity homeActivity);
}
