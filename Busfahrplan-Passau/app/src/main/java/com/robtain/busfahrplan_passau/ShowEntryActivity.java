package com.robtain.busfahrplan_passau;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by RobTain on 29.01.2016.
 */
public class ShowEntryActivity extends AppCompatActivity {
    private String keyword;
    private BusStation busStop;
    private ImageView imageView;
    private int currentPage = 0;
    private Tools tools;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
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
        String path = "p" + keyword + "_" + busStop.getId();

       Resources res = getResources();
        int id = res.getIdentifier(path, "drawable",getPackageName());
        imageView.setImageResource(id);
    }

    private void zoom() {
        final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        imageView.setAnimation(zoomin);
        imageView.setAnimation(zoomout);
        //TODO better zoom in and out (set pivot!!!)
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        v.startAnimation(zoomout);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        v.startAnimation(zoomin);
                        break;
                }
                return true;
            }
        });
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
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);
        }
    }
}


