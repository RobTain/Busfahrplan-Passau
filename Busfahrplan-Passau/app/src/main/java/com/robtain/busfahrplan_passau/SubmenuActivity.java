package com.robtain.busfahrplan_passau;

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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by RobTain on 01.03.2016.
 */
public class SubmenuActivity extends AppCompatActivity {
    private ListView listView;
    private LinkedList busStations;
    private String keyword;
    private Tools tools;
    private BusLine busLine;
    private BusStation bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu);

        //set color statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        tools = new Tools();
        busLine = new BusLine();


        //get keyword
        Intent i = getIntent();
        keyword = i.getStringExtra("keyword");

        //set title
        setTitle(tools.transformKeywordIntoTitle(keyword));
        busStations = busLine.getBusLine(keyword);

        //set NavMenu
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
                        Intent i = new Intent(SubmenuActivity.this, tools
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


        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listsubmenu);
        // Define (title) values to show in ListView
        String[] values = new String[busStations.size()];

        for (int j = 0; j < values.length; j++) {
            bs = (BusStation) busStations.get(j);
            values[j] = bs.getTitle();
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.submenu_style, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String itemValue = (String) listView.getItemAtPosition(position);
                Object o = new Object();
                for (int i = 0; i < busStations.size(); i++) {
                    o = busStations.get(i);
                    bs = (BusStation) o;
                    if (bs.getTitle().equals(itemValue)) {
                        break;
                    }
                }

                finish();
                Intent i = new Intent(SubmenuActivity.this,
                        ShowEntryActivity.class);
                i.putExtra("keyword", keyword);
                i.putExtra("busstop", bs);
                startActivity(i);
            }

        });
    }


    /**
     * Back key send a request from SubmenuActivity -> Startmenu
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(SubmenuActivity.this, StartActivity.class);
            startActivity(menu);
        }
    }



}
