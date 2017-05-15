package com.ragecoders.mseries.di.module;

import com.ragecoders.mseries.datasource.model.interfaces.OmdbApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ferquies on 14/05/17.
 */
@Module
public class OmdbApiModule {
    private static final String URL_BASE = "http://www.omdbapi.com/";

    public OmdbApiModule() {}

    @Provides static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_BASE)
                .build();
    }

    @Provides static OmdbApi provideOmdbApi(Retrofit retrofit) {
        return retrofit.create(OmdbApi.class);
    }
}
