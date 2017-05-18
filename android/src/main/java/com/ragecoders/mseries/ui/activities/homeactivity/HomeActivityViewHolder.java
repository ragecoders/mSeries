package com.ragecoders.mseries.ui.activities.homeactivity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ragecoders.mseries.R;
import com.ragecoders.mseries.ui.BasicViewHolder;
import javax.inject.Inject;

/**
 * Created by Fernando Q. Esquitino
 * Mail: fernando@ragecoders.com
 * Web: ragecoders.com
 * 17/05/17
 */
public class HomeActivityViewHolder implements BasicViewHolder {
  @BindView(R.id.drawer_layout) DrawerLayout drawer;
  @BindView(R.id.nav_view) NavigationView navigationView;
  @BindView(R.id.home_activity_tv_description) TextView tvDescription;
  @BindView(R.id.home_activity_image) ImageView image;

  private Unbinder unbinder;

  @Inject public HomeActivityViewHolder(View view) {
    unbinder = ButterKnife.bind(this, view);
  }

  @Override public void unbind() {
    unbinder.unbind();
  }
}
