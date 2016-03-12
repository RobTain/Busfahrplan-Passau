package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



/**
 * Created by RobTain on 29.01.2016.
 */
public class ShowEntryActivity extends AppCompatActivity {
    private String keyword;
    private BusStation busStop;
    private ImageView imageView;
    private Tools tools;
    private boolean zoomout = true;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        view = this.findViewById(android.R.id.content);
        tools = new Tools();

        //get keyword
        Intent i = getIntent();
        keyword = i.getStringExtra("keyword");
        busStop = (BusStation) i.getExtras().getSerializable("busstop");

        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        //set title
        setTitle(tools.transformKeywordIntoTitle(keyword));

        // NavMenu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        Tools tools = new Tools();
                        Intent i = new Intent(ShowEntryActivity.this, tools
                                .selectPath(item));
                        String keyword = tools.getCodeword();
                        i.putExtra("keyword", keyword);
                        openView(i);
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                }

                    /**
                     * opens new View
                     * @param i
                     */
                    private void openView(Intent i) {
                        finish();
                        startActivity(i);
                    }
                });

        imageView = (ImageView) findViewById(R.id.searchResult);
        //find Pic
        findPicture();
        //set Zoom
        zoom();
    }

    private void findPicture() {
        String path = "p" + keyword.toLowerCase() + "_" + busStop.getId();
        //Log.e(path, path);

       Resources res = getResources();
        int id = res.getIdentifier(path, "drawable",getPackageName());
        imageView.setImageResource(id);
    }

    private void zoom() {
        //set hardware layer for animation performance
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim
                .initialzoom);
        imageView.setAnimation(zoomout);
        view.setLayerType(View.LAYER_TYPE_NONE, null);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.startAnimation(zoomout);
                imageView.setAnimation(null);
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        float x = event.getX();
                        float y = event.getY();
                        zoomhelper(x, y);
                        break;
                }
                return true;
            }
        });
    }

    private void zoomhelper(float x, float y) {
        if (zoomout) {
            zoomout = !zoomout;
            imageView.setScaleX(2);
            imageView.setScaleY(2);
            imageView.setPivotX(x);
            imageView.setPivotY(y);
        } else {
            zoomout = !zoomout;
            imageView.setScaleX(1);
            imageView.setScaleY(1);
        }
    }

    /**
     * return to submenu
     */
    @Override
    public void onBackPressed() {
        imageView = null;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(ShowEntryActivity.this, SubmenuActivity.class);
            menu.putExtra("keyword", keyword);
            startActivity(menu);
        }
    }
}


