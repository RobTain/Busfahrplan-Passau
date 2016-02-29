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
    public boolean premiumVersion = false;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);


        //check brought version
        if (premiumVersion()) {
            premiumVersion = true;
        }

        //set premium information session scoped
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("premium", premiumVersion);
        editor.apply();


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
                            i = new Intent(StartActivity.this, SubmenuMathActivity.class);
                            openView(i);

                        } else if (id == R.id.physicsNavMenu) {
                            i = new Intent(StartActivity.this, SubmenuPhysicActivity.class);
                            openView(i);
                        } else if (id == R.id.computerscienceNavMenu) {
                            i = new Intent(StartActivity.this, SubmenuInformaticActivity.class);
                            openView(i);

                        } else if (id == R.id.chemistryNavMenu) {
                            i = new Intent(StartActivity.this, SubmenuChemistryActivity.class);
                            openView(i);
                        } else if (id == R.id.biologyNavMenu) {
                            i = new Intent(StartActivity.this, SubmenuBiologyActivity.class);
                            openView(i);
                        } else if (id == R.id.accountingNavMenu) {
                            i = new Intent(StartActivity.this, SubmenuAccountingActivity.class);
                            openView(i);
                        } else if (id == R.id.searchNavMenu) {
                            i = new Intent(StartActivity.this, SearchActivity.class);
                            openView(i);

                        } else if (id == R.id.lexiconNavMenu) {
                            i = new Intent(StartActivity.this, LexiconActivity.class);
                            openView(i);
                        } else if (id == R.id.contactNavMenu) {
                            i = new Intent(StartActivity.this, ContactActivity.class);
                            openView(i);
                        } else if (id == R.id.rateNavMenu) {
                            i = new Intent(StartActivity.this, RateAppActivity.class);
                            openView(i);
                        } else if (id == R.id.buyPremiumNavMenu) {
                            i = new Intent(StartActivity.this, BuyPremiumActivity.class);
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
     * This method returns status of the premiumversion
     *
     * @return true = brought Version, false = standard version
     */
    private boolean premiumVersion() {
        boolean b;

        String packagename = getPackageName();

        if (packagename.contains("free")) {
            b = false;
        } else if (packagename.contains("premium")) {
            b = true;
        } else {
            b = false;
        }
        return b;
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