package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
 * Created by RobTain on 29.01.2016.
 */
public class SubmenuPhysicActivity extends AppCompatActivity {
    ListView listView;
    LinkedList sublist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu);


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
                        int id = item.getItemId();
                        Intent i;

                        if (id == R.id.mathematicsNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SubmenuMathActivity.class);
                            openView(i);

                        } else if (id == R.id.physicsNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SubmenuPhysicActivity.class);
                            openView(i);

                        } else if (id == R.id.computerscienceNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this,
                                    SubmenuInformaticActivity.class);
                            openView(i);

                        } else if (id == R.id.chemistryNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SubmenuChemistryActivity.class);
                            openView(i);
                        } else if (id == R.id.biologyNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SubmenuBiologyActivity.class);
                            openView(i);
                        } else if (id == R.id.accountingNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SubmenuAccountingActivity.class);
                            openView(i);

                        } else if (id == R.id.searchNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, SearchActivity.class);
                            openView(i);

                        } else if (id == R.id.lexiconNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, LexiconActivity.class);
                            openView(i);
                        } else if (id == R.id.contactNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, ContactActivity.class);
                            openView(i);
                        } else if (id == R.id.rateNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, RateAppActivity.class);
                            openView(i);
                        } else if (id == R.id.buyPremiumNavMenu) {
                            i = new Intent(SubmenuPhysicActivity.this, BuyPremiumActivity.class);
                            openView(i);
                        }

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

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listsubmenu);

        // Defined Array values to show in ListView
        Lexicon lexicon = new Lexicon();
        sublist = lexicon.getSublist(Topic.Physic);
        LexiconEntry entry;

        String[] values = new String[sublist.size()];

        for (int i = 0; i < values.length; i++) {
            entry = (LexiconEntry) sublist.get(i);
            values[i] = entry.getTitle();
        }


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.submenu_style,
                android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String itemValue = (String) listView.getItemAtPosition(position);
                Object o = new Object();
                LexiconEntry lexiconEntry;
                for (int i = 0; i < sublist.size(); i++) {
                    o = sublist.get(i);
                    lexiconEntry = (LexiconEntry) o;
                    if (lexiconEntry.getTitle().equals(itemValue)) {
                        String[] keywords = lexiconEntry.getKeywords();
                        itemValue = keywords[0];
                        break;
                    }
                }
                setSearchWord(itemValue);
                finish();
                Intent menu = new Intent(SubmenuPhysicActivity.this, ShowEntryActivity.class);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                startActivity(menu);
            }

        });
    }


    private void setSearchWord(String word) {
        word = word.toLowerCase().trim();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("searchword", word);
        editor.apply();
    }

    /**
     * functional back key
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(SubmenuPhysicActivity.this, StartActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);
        }
    }
}