package com.robtain.busfahrplan_passau;
//TODO App bewerten auf Link setzen
//TODO Zoomfunktion
//TODO Favoriten anzeigen auf Favoritenseite

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;



public class StartActivity extends AppCompatActivity {
    private ImageView imageView;
    private boolean zoomout = true;
    private View view;
    private Tools tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        view = this.findViewById(android.R.id.content);

        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        // set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // set icon favourites
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext()
                , R.drawable.favourites);
        toolbar.setOverflowIcon(drawable);
        setSupportActionBar(toolbar);

        //set NavMenu
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
                        tools = new Tools();
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

        //set R.drawable to imageview
        imageView = (ImageView) findViewById(R.id.lineplan);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable
                .line_plan));
        zoom();

        //set File
        createFile();

    }

    private void createFile() {
        if (isExternalStorageWritable()) {
            File path = getExternalFilesDir(null);
            File file = new File(path, "Busfahrplan_Passau");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
                Toast.makeText(getBaseContext(), "Bitte für mehr Speicherplatz " +
                        "sorgen", Toast.LENGTH_SHORT).show();
            }
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
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

    /**
     * creates OptionMenu on the toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_right, menu);
        return true;
    }


    /**
     * handles onclick on MenuItem (OptionMenu)
     * @param item
     */
   public void startFavouritesIntent(MenuItem item) {
       tools = new Tools();
       Intent i = new Intent(StartActivity.this, FavouritenActivity.class);
       finish();
       startActivity(i);

    }

}