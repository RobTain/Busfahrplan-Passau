package com.robtain.busfahrplan_passau;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

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
                        Intent i = new Intent(StartActivity.this, tools
                                .getNavMenu(item));
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
                        //TODO search for better animation!!!
                        overridePendingTransition(R.anim.slide_in, R.anim
                                .slide_out);
                        startActivity(i);
                    }


                });

        final EditText editText = (EditText) findViewById(R.id.inputStartView);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText.setTypeface(null, Typeface.NORMAL);
            }
        });

        search = (Button) findViewById(R.id.searchButtonStartView);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mText = (EditText) findViewById(R.id.inputStartView);
                String word = mText.getText().toString();

                if (word.length() == 0) {
                    //create Alert for empty text
                    sendErrorMessage();
                } else {
                    setSearchWord(word);
                    finish();
                    Intent menu = new Intent(StartActivity.this, ShowEntryActivity.class);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    startActivity(menu);
                }
            }
        });
    }

    /**
     * creating error message (empty request)
     */
    private void sendErrorMessage() {
        AlertDialog.Builder messageMissingInput = new AlertDialog.Builder(this);
        messageMissingInput.setTitle("Fehlende Eingabe...");
        messageMissingInput.setMessage("Bitte geben Sie einen Text ein, bevor Sie fortfahren!");
        messageMissingInput.setNeutralButton("OK", null);
        messageMissingInput.setIcon(R.drawable.warning);
        messageMissingInput.show();
    }

    /**
     * setting search word
     *
     * @param word entered input
     */
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
            super.onBackPressed();
        }
    }
}