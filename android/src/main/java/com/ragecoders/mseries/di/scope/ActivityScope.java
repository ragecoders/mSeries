package com.ragecoders.mseries.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import dagger.releasablereferences.CanReleaseReferences;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ferquies on 14/05/17.
 */
@Documented
@Retention(RUNTIME)
@CanReleaseReferences
@Scope
public @interface ActivityScope {
}
