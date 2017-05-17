package com.ragecoders.mseries.di.module;

import com.ragecoders.datasource.api.OmdbApiService;
import com.ragecoders.mseries.di.scope.ActivityScope;
import com.ragecoders.mseries.homeactivity.HomeActivityPresenter;
import com.ragecoders.mseries.homeactivity.HomeActivityPresenterImpl;
import com.ragecoders.mseries.homeactivity.HomeActivityView;
import com.ragecoders.mseries.ui.activities.HomeActivity.HomeActivity;
import com.ragecoders.mseries.ui.activities.HomeActivity.HomeActivityViewHolder;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 17/05/17
 */
@Module public class HomeActivityModule {
  private static final String URL_BASE = "http://www.omdbapi.com/";
  private HomeActivity homeActivity;

  public HomeActivityModule(HomeActivity homeActivity) {
    this.homeActivity = homeActivity;
  }

  @Provides @ActivityScope HomeActivityView provideHomeActivityView() {
    return homeActivity;
  }

  @Provides @ActivityScope HomeActivityPresenter provideHomeActivityPresenter(
      HomeActivityPresenterImpl presenter) {
    return presenter;
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

  @Provides @ActivityScope HomeActivityViewHolder provideHomeActivityViewHolder() {
    return new HomeActivityViewHolder(homeActivity.getRootView());
  }
}
