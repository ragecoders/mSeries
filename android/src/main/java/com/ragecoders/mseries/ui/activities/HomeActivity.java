package com.ragecoders.mseries.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.ragecoders.datasource.api.OmdbApiService;
import com.ragecoders.datasource.api.model.Series;
import com.ragecoders.mseries.BaseActivity;
import com.ragecoders.mseries.R;
import com.ragecoders.mseries.di.component.DaggerHomeActivityComponent;
import com.ragecoders.mseries.di.component.HomeActivityComponent;
import com.ragecoders.mseries.di.module.HomeActivityModule;
import com.ragecoders.mseries.homeactivity.HomeActivityPresenter;
import com.ragecoders.mseries.homeactivity.HomeActivityView;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 14/05/17
 */
public class HomeActivity extends BaseActivity
    implements HomeActivityView, NavigationView.OnNavigationItemSelectedListener {

  @BindView(R.id.drawer_layout) DrawerLayout drawer;
  @BindView(R.id.nav_view) NavigationView navigationView;
  @BindView(R.id.home_activity_tv_description) TextView tvDescription;
  @BindView(R.id.home_activity_image) ImageView image;

  @Inject OmdbApiService omdbApiService;
  @Inject HomeActivityPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    injectDependencies();
    initializeView();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_search_view, menu);

    final MenuItem searchItem = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
    searchView.setQueryHint(getText(R.string.action_search));
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        presenter.search(query);
        searchView.setQuery("", false);
        searchView.setIconified(true);
        return true;
      }

      @Override public boolean onQueryTextChange(String newText) {
        //textView.setText(newText);
        return true;
      }
    });

    return super.onCreateOptionsMenu(menu);
  }

  private void initializeView() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  private void injectDependencies() {
    HomeActivityComponent homeActivityComponent = DaggerHomeActivityComponent.builder()
        .homeActivityModule(new HomeActivityModule(this))
        .build();
    homeActivityComponent.inject(this);
  }

  @Override public void search(String text) {
    Observable<Series> series = omdbApiService.getSeries(text, "full");
    series.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(seriesResult -> {
          tvDescription.setText(seriesResult.getPlot());
          Glide.with(this).load(seriesResult.getPoster()).into(image);
        }, error -> {
          Toast.makeText(HomeActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT)
              .show();
        });
  }

  @Override public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @SuppressWarnings("StatementWithEmptyBody") @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_home) {

    } else if (id == R.id.nav_following) {

    } else if (id == R.id.nav_favorites) {

    } else if (id == R.id.nav_explore) {

    } else if (id == R.id.nav_configuration) {

    } else if (id == R.id.nav_about) {

    }

    drawer.closeDrawer(GravityCompat.START);

    return true;
  }
}
