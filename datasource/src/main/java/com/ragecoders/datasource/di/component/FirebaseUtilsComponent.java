package com.ragecoders.datasource.di.component;

import com.ragecoders.datasource.api.FirebaseUtils;
import com.ragecoders.datasource.di.module.FirebaseUtilsModule;
import com.ragecoders.datasource.di.scope.ActivityScope;
import dagger.Component;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 18/05/17
 */
@ActivityScope @Component(modules = { FirebaseUtilsModule.class })
public interface FirebaseUtilsComponent {
  void inject(FirebaseUtils firebaseUtils);
}
