package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by RobTain on 01.03.2016.
 */
public class SubmenuActivity extends AppCompatActivity {
    ListView listView;
    LinkedList sublist;
    String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu);
        //get keyword
        Intent i = getIntent();
        keyword = i.getStringExtra("keyword");



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
                        int id = item.getItemId();
                        Intent i;

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
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        startActivity(i);
                    }

                });


//        // Get ListView object from xml
//        listView = (ListView) findViewById(R.id.listsubmenu);
//
//        // Defined Array values to show in ListView
//        Lexicon lexicon = new Lexicon();
//        sublist = lexicon.getSublist(Topic.Informatic);
//        LexiconEntry entry;
//
//        String[] values = new String[sublist.size()];
//
//        for (int i = 0; i < values.length; i++) {
//            entry = (LexiconEntry) sublist.get(i);
//            values[i] = entry.getTitle();
//        }
//
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Forth - the Array of data
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.submenu_style,
//                android.R.id.text1, values);
//
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);
//
//        // ListView Item Click Listener
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                String itemValue = (String) listView.getItemAtPosition(position);
//                Object o = new Object();
//                LexiconEntry lexiconEntry;
//                for (int i = 0; i < sublist.size(); i++) {
//                    o = sublist.get(i);
//                    lexiconEntry = (LexiconEntry) o;
//                    if (lexiconEntry.getTitle().equals(itemValue)) {
//                        String[] keywords = lexiconEntry.getKeywords();
//                        itemValue = keywords[0];
//                        break;
//                    }
//                }
//                setSearchWord(itemValue);
//                finish();
//               // Intent menu = new Intent(SubmenuAccountingActivity.this,
//                //     ShowEntryActivity.class);
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//              //  startActivity(menu);
//            }
//
//        });
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
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);
        }
    }
}

