package com.ragecoders.mseries.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ragecoders.mseries.R;
import com.ragecoders.mseries.datasource.model.domain.Series;
import com.ragecoders.mseries.datasource.model.interfaces.OmdbApi;
import com.ragecoders.mseries.di.component.DaggerOmdbApiComponent;
import com.ragecoders.mseries.di.component.OmdbApiComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.home_activity_tv_description)
    TextView tvDescription;
    @BindView(R.id.home_activity_image)
    ImageView image;

    @Inject
    Retrofit retrofit;

    @Inject
    OmdbApi omdbApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        injectDependencies();
        initializeView();
        useApi();
    }

    private void initializeView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void injectDependencies() {
        OmdbApiComponent omdbApiComponent = DaggerOmdbApiComponent.builder().build();
        omdbApiComponent.inject(this);
    }

    private void useApi() {
        Observable<Series> series = omdbApi.getSeries("Doctor Who");
        series.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(serie -> {
                    Log.e("Doctor Who", serie.getPlot());
                    tvDescription.setText(serie.getPlot());
                    Glide.with(this)
                            .load(serie.getPoster())
                            .into(image);
                });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
