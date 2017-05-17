package com.ragecoders.datasource.api;

import com.ragecoders.datasource.api.model.Series;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ferquies on 14/05/17.
 */

public interface OmdbApiService {
  @GET("?") Observable<Series> getSeries(@Query("t") String title, @Query("plot") String plot);
}
