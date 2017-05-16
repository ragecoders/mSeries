package com.ragecoders.mseries.datasource.model.interfaces;

import com.ragecoders.mseries.datasource.model.domain.Series;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ferquies on 14/05/17.
 */

public interface OmdbApi {
  @GET("?") Observable<Series> getSeries(@Query("t") String title, @Query("plot") String plot);
}
