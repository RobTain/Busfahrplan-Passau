package com.robtain.busfahrplan_passau;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by RobTain on 16.03.2016.
 */
public class FavouritenActivity extends AppCompatActivity {
    private View view;
    private String[] busLines;
    private String[] busStops;
    private Tools tools;
    private ListView listView;
    private LinkedList<BusStation> fav;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites);
        view = this.findViewById(android.R.id.content);


        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        // set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
                        //test
                        Intent i = new Intent(FavouritenActivity.this, tools
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

         listView = (ListView) findViewById(R.id.favouritesList);
        setListView();





    }


    private void setListView() {

        File file = null;
        if (isExternalStorageReadable()) {
            File path = getExternalFilesDir(null);
            file = new File(path, "Busfahrplan_Passau");
            // catch text
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

            // set listview
            String oldText = text.toString();
            String[] keywords = oldText.split("entry");
            int size = keywords.length-1;

            busLines = new String[size];
            busStops = new String[size];

           String letter;
            //fill values
            for (int i = 0; i < size; i++) {
                int t = i + 1;
                String tmp = keywords[t].trim();
                String first = tmp.substring(0, tmp.length() - 2);
                if ( (letter = first.substring(first.length()-1)).equals
                        ("_")) {
                    first = first.substring(0,first.length()-1);
                }

                String second = new StringBuffer(tmp).reverse().toString()
                        .substring(0,2);
                second = new StringBuffer(second).reverse().toString();
                if ( (letter = second.substring(0,1)).equals("_")) {
                    second = second.substring(1,2);
                }


                busLines[i] = first;
                busStops[i] = second;
            }


            // get busstation objects
            fav = new LinkedList<BusStation>();
            LinkedList tmp;
            tools = new Tools();
            Object o;
            for (int j = 0; j < busLines.length; j++) {
                int t = j;
                if (busLines[t].toString().equals("8_9_kohl_koenig")) {
                    tmp = tools.findBusLine("8_9_Kohl_Koenig");
                } else if ( busLines[t].toString().equals("8_9_koenig_kohl")) {
                    tmp = tools.findBusLine("8_9_Koenig_Kohl");
                } else {
                    tmp = tools.findBusLine(busLines[t].toUpperCase());
                }
                setFavHelper(tmp, t);

            }
            //set listview
            String[] values = new String[fav.size()];
            BusStation bs;
            for (int x = 0; x < fav.size();x++) {
                bs = fav.get(x);
                values[x] = tools.transformKeywordIntoTitle(bs.getLine()) +
                        ": " + "\n" + bs.getTitle();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.submenu_style, android.R.id.text1, values);
            listView.setAdapter(adapter);

            // ListView Item Click Listener
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {


                    BusStation bs = fav.get(position);

                    finish();
                    Intent i = new Intent(FavouritenActivity.this,
                            ShowEntryActivity.class);
                   i.putExtra("keyword", bs.getLine());
                  i.putExtra("busstop", bs);
                    i.putExtra("favourit", true);
                    startActivity(i);
                }

            });


        } else {
            Toast.makeText(getBaseContext(), "Bitte für mehr Speicherplatz " +
                    "sorgen", Toast.LENGTH_SHORT).show();
        }

    }

    private void setFavHelper(LinkedList tmp, int t) {
        Object o;
        BusStation bs;
        for (int i = 0; i < tmp.size(); i++) {
            o = tmp.get(i);
            bs = (BusStation) o;
            if (bs.getId().equals(busStops[t])) {
                fav.add(bs);
            }

        }
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment
                .MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    /**
     * Back key send a request from FavouritenActivity -> Startmenu
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(FavouritenActivity.this, StartActivity.class);
            startActivity(menu);
        }
    }

}
