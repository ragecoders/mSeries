package com.ragecoders.mseries.homeactivity;

import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 17/05/17
 */
public class HomeActivityPresenterImpl implements HomeActivityPresenter {

  @Inject HomeActivityView view;

  @Inject public HomeActivityPresenterImpl() {
  }

  @Override public void search(String text) {
    view.search(text);
  }
}
