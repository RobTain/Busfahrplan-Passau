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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by RobTain on 29.01.2016.
 */
public class ShowEntryActivity extends AppCompatActivity {
    private String keyword;
    private BusStation busStop;
    private ImageView imageView;
    private Tools tools;
    private boolean zoomout = true;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        tools = new Tools();

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);

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
//

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


