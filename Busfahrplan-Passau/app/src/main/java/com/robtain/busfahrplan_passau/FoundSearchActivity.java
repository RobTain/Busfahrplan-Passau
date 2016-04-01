package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by RobTain on 12.03.2016.
 */
public class FoundSearchActivity extends AppCompatActivity {
    private Tools tools;
    private LinkedList<BusStation> foundSearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found_search);
        tools = (Tools) getIntent().getExtras().getSerializable("search");
        foundSearch = tools.getBusStationLinkedList();

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
                        Intent i = new Intent(FoundSearchActivity.this, tools
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

        final EditText editText = (EditText) findViewById(R.id
                .searchFoundInput);
        editText.getBackground().setColorFilter(getResources().getColor(R.color.swp_blue),
                PorterDuff.Mode
                        .SRC_IN);
        Button button = (Button) findViewById(R.id.searchFoundButton);
        tools = new Tools();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable input = editText.getText();
                String enteredInput = input.toString();
                if (enteredInput != null) {
                    tools.search(enteredInput);
                    Intent i = new Intent(FoundSearchActivity.this,
                            FoundSearchActivity.class);
                    i.putExtra("search", tools);
                    finish();
                    startActivity(i);
                }
            }
        });

        BusStation bs;
        String[] values = new String[foundSearch.size()];

        for (int j = 0; j < values.length; j++) {
            bs = foundSearch.get(j);
            values[j] = tools.transformKeywordIntoTitle(bs.getLine()) + ": \n" +bs
                    .getTitle();
        }


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.submenu_style, android.R.id.text1, values);
        final ListView listView = (ListView) findViewById(R.id.searchFoundList);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                BusStation bs = foundSearch.get(position);

                finish();
                Intent i = new Intent(FoundSearchActivity.this,
                        ShowEntryActivity.class);
                i.putExtra("keyword", bs.getLine());
                i.putExtra("busstop", bs);
                i.putExtra("search", true);
                startActivity(i);
            }

        });
    }

    /**
     * return to startview
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(FoundSearchActivity.this, StartActivity.class);
            startActivity(menu);
        }
    }

}