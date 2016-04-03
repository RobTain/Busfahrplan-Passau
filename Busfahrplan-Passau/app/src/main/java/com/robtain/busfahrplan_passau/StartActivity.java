package com.robtain.busfahrplan_passau;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;



public class StartActivity extends AppCompatActivity {
    private boolean zoomout = true;
    private View view;
    private Tools tools;
    private Boolean animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        view = this.findViewById(android.R.id.content);
        initialSetting();

        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        // set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        ImageViewZoom image = (ImageViewZoom) findViewById(R.id.lineplan);
        Drawable drawable = getResources().getDrawable(R.drawable.line_plan);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        image.setImageBitmap(bitmap);
        if (animation) {
            view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim
                    .initialzoom);
            image.setAnimation(zoomout);
            view.setLayerType(View.LAYER_TYPE_NONE, null);
        }

        //set File
        createFile();

    }

    private void initialSetting() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        if(!preferences.contains("animation")) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("animation", true);
            animation = true;
            editor.apply();
        } else {
            animation = preferences.getBoolean("animation", true);
        }

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



    /**
     * Back key will end application
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.end_app_title)
                    .setMessage(R.string.end_app_message)
                    .setIcon(R.drawable.warning)
                    .setNegativeButton(R.string.end_app_button_false, new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton(R.string.end_app_button_true,
                            new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }
                    })
                    .show();
        }
    }



}