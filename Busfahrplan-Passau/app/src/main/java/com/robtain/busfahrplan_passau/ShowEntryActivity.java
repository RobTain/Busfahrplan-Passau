package com.robtain.busfahrplan_passau;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by RobTain on 29.01.2016.
 */
public class ShowEntryActivity extends AppCompatActivity {
    private String searchword;
    private String title;
    private String description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);


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

      
    }

    /**
     * search lexicon for the request
     *
     * @param searchword entered input
//     */
//    private void searchLexicon(String searchword) {
//        Lexicon lexicon = new Lexicon();
//        LexiconEntry lexiconEntry = lexicon.findEntry(searchword);
//        if (lexiconEntry == null) {
//            this.title = "Kein Erfolg!";
//            this.description = null;
//        } else if (lexiconEntry.isPremium()) {
//            this.title = "Standard Version";
//            this.description = "Zum Betrachten der Formel kaufen Sie sich Bitte die Premiumversion";
//            //ToDO Bild von PremiumVersion einfÃ¼gen
//        } else {
//            this.title = lexiconEntry.getTitle();
//            this.description = lexiconEntry.getDescription();
//        }
//        setView();
//    }

    /**
     * creating the view with the search result
     */
    private void setView() {
        setTitle(this.title);

        if (description != null) {
            int id = getResources().getIdentifier(description, "drawable", getPackageName());
            Bitmap dd = BitmapFactory.decodeResource(getResources(), id);
            ImageView imageView = (ImageView) findViewById(R.id.searchResultDescription);
            imageView.setImageBitmap(dd);
        }
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
            Intent menu = new Intent(ShowEntryActivity.this, SubmenuActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);
        }
    }
}


