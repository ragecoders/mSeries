package com.ragecoders.mseries.di.module;

import com.ragecoders.datasource.api.OmdbApiService;
import com.ragecoders.mseries.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 14/05/17
 */
@Module public class BaseActivityModule {
  private static final String URL_BASE = "http://www.omdbapi.com/";

  public BaseActivityModule() {
  }

  @Provides @ActivityScope Retrofit provideRetrofit() {
    return new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL_BASE)
        .build();
  }

  @Provides @ActivityScope OmdbApiService provideOmdbApi(Retrofit retrofit) {
    return retrofit.create(OmdbApiService.class);
  }
}
