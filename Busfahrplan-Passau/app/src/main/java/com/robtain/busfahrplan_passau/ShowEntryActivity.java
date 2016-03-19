package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by RobTain on 29.01.2016.
 */
public class ShowEntryActivity extends AppCompatActivity {
    private String keyword;
    private BusStation busStop;
    private Tools tools;
    private boolean zoomout = true;
    private View view;
    private Boolean checkMenuRight;

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


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         //set title
        toolbar.setTitle(tools.transformKeywordIntoTitle(keyword));
        // set icon favourites
        toolbar.setOverflowIcon(checkIcon());
        setSupportActionBar(toolbar);

        // set NavMenu
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

        ImageViewZoom image = (ImageViewZoom) findViewById(R.id.searchResult);
        Drawable drawable = getResources().getDrawable(findPicture());
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        image.setImageBitmap(bitmap);
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim
                .initialzoom);
        image.setAnimation(zoomout);
        view.setLayerType(View.LAYER_TYPE_NONE, null);

    }

    private Drawable checkIcon() {
        Drawable drawable;
        boolean b = checkFile();
        checkMenuRight = b;
        if (b) {
            drawable = ContextCompat.getDrawable(getApplicationContext()
                    , R.drawable.favourites_added);
        } else {
        drawable = ContextCompat.getDrawable(getApplicationContext()
                    , R.drawable.add_fav);
        }
        return drawable;
    }

    private boolean checkFile() {
        Boolean b = false;
        String s = "";
        if (isExternalStorageReadable()) {

            File path = getExternalFilesDir(null);
            File file = new File(path, "Busfahrplan_Passau");
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                try {
                    while ( (line = br.readLine()) != null) {
                        text.append(line);
                    }
                    br.close();
                } catch (IOException e) {
                   b = false;
                }

            } catch (FileNotFoundException e) {
                b = false;
            }
            String log = text.toString();
            String entry = "entry" + keyword.toLowerCase() + "_" + busStop
                    .getId();
            if (log.contains(entry)) {
                b = true;
            }
        }
        else {
        Toast.makeText(getBaseContext(), "Bitte für mehr Speicherplatz " +
                    "sorgen", Toast.LENGTH_SHORT).show();
        }
        return b;
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment
                .MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    private int findPicture() {
        String path = "p" + keyword.toLowerCase() + "_" + busStop.getId();

       Resources res = getResources();
        int id = res.getIdentifier(path, "drawable",getPackageName());
       return id;
    }


    /**
     * return to submenu
     */
    @Override
    public void onBackPressed() {
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

    /**
     * creates OptionMenu on the toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!checkMenu()) {
            getMenuInflater().inflate(R.menu.menu_right_add_fav, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_delete, menu);
        }
        return true;
    }

    private boolean checkMenu() {
        return checkMenuRight;
    }

    public void addFavourite(MenuItem item) {
        File file = null;
        if (isExternalStorageWritable()) {
            File path = getExternalFilesDir(null);
            file = new File(path, "Busfahrplan_Passau");
            String newEntry = "entry" + keyword.toLowerCase() + "_" + busStop
                    .getId();
            // catch old text
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                try {
                    while ( (line = br.readLine()) != null) {
                        text.append(line);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // update file
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                if (text.toString() == null) {
                        br.write(newEntry);

                } else {
                    br.write(text.toString());
                    br.write(" ");
                    br.write(newEntry);
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getBaseContext(), "Bitte für mehr Speicherplatz " +
                    "sorgen", Toast.LENGTH_SHORT).show();
        }

        finish();
        Intent i = new Intent(ShowEntryActivity.this,
                ShowEntryActivity.class);
        i.putExtra("keyword", keyword);
        i.putExtra("busstop", busStop);
        startActivity(i);
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }


    public void deleteFavourite(MenuItem menu) {
        File file = null;
        if (isExternalStorageWritable()) {
            File path = getExternalFilesDir(null);
            file = new File(path, "Busfahrplan_Passau");
            String entry = "entry" + keyword.toLowerCase() + "_" + busStop
                    .getId();
            // catch old text
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                try {
                    while ( (line = br.readLine()) != null) {
                        text.append(line);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // update file
            String oldText = text.toString();
            String newEntry = "";
            String replace = oldText.replace(entry,newEntry);
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                br.write(replace);
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getBaseContext(), "Bitte für mehr Speicherplatz " +
                    "sorgen", Toast.LENGTH_SHORT).show();
        }


        finish();
        Intent i = new Intent(ShowEntryActivity.this,
                ShowEntryActivity.class);
        i.putExtra("keyword", keyword);
        i.putExtra("busstop", busStop);
        startActivity(i);
    }


}


