package com.ragecoders.mseries.di.component;

import com.ragecoders.mseries.di.module.OmdbApiModule;
import com.ragecoders.mseries.di.scope.ActivityScope;
import com.ragecoders.mseries.view.HomeActivity;
import dagger.Component;

/**
 * Created by ferquies on 14/05/17.
 */
@ActivityScope @Component(modules = OmdbApiModule.class) public interface OmdbApiComponent {
  void inject(HomeActivity homeActivity);
}
