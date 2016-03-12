package com.robtain.busfahrplan_passau;
//TODO Icon machen
//TODO Icon in Nav setzen
//TODO Submenu schrift fett
//TODO App bewerten auf Link setzen
//TODO Zoomfunktion

import android.annotation.TargetApi;
import android.content.Intent;
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


public class StartActivity extends AppCompatActivity {
    private ImageView imageView;
    private boolean zoomout = true;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);


        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

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
                        //test
                        Intent i = new Intent(StartActivity.this, tools
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
        imageView = (ImageView) findViewById(R.id.lineplan);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable
                .line_plan));

        zoom();
    }

    private void zoom() {
        final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim
                .initialzoom);
        imageView.setAnimation(zoomout);
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
            imageView.setScaleX(3);
            imageView.setScaleY(3);
            imageView.setPivotX(x);
            imageView.setPivotY(y);
        } else {
            zoomout = !zoomout;
            imageView.setScaleX(1);
            imageView.setScaleY(1);
        }
    }

    /**
     * Back key will end application
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}