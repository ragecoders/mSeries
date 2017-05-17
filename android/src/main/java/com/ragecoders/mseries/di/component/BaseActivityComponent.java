package com.ragecoders.mseries.di.component;

import com.ragecoders.mseries.ui.activities.BaseActivity;
import com.ragecoders.mseries.di.module.BaseActivityModule;
import com.ragecoders.mseries.di.scope.ActivityScope;
import dagger.Component;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 14/05/17
 */
@ActivityScope @Component(modules = BaseActivityModule.class)
public interface BaseActivityComponent {
  void inject(BaseActivity baseActivity);
}
