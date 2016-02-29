package formula.freeversion;

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
import android.widget.TextView;

/**
 * Created by RobTain on 29.01.2016.
 */
public class SearchActivity extends AppCompatActivity {
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        // NavMenu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
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
                            i = new Intent(SearchActivity.this, SubmenuMathActivity.class);
                            openView(i);

                        } else if (id == R.id.physicsNavMenu) {
                            i = new Intent(SearchActivity.this, SubmenuPhysicActivity.class);
                            openView(i);
                        } else if (id == R.id.computerscienceNavMenu) {
                            i = new Intent(SearchActivity.this, SubmenuInformaticActivity.class);
                            openView(i);
                        } else if (id == R.id.chemistryNavMenu) {
                            i = new Intent(SearchActivity.this, SubmenuChemistryActivity.class);
                            openView(i);
                        } else if (id == R.id.biologyNavMenu) {
                            i = new Intent(SearchActivity.this, SubmenuBiologyActivity.class);
                            openView(i);
                        } else if (id == R.id.accountingNavMenu) {
                            i = new Intent(SearchActivity.this, SubmenuAccountingActivity.class);
                            openView(i);
                        } else if (id == R.id.searchNavMenu) {
                            i = new Intent(SearchActivity.this, SearchActivity.class);
                            openView(i);

                        } else if (id == R.id.lexiconNavMenu) {
                            i = new Intent(SearchActivity.this, LexiconActivity.class);
                            openView(i);
                        } else if (id == R.id.contactNavMenu) {
                            i = new Intent(SearchActivity.this, ContactActivity.class);
                            openView(i);
                        } else if (id == R.id.rateNavMenu) {
                            i = new Intent(SearchActivity.this, RateAppActivity.class);
                            openView(i);
                        } else if (id == R.id.buyPremiumNavMenu) {
                            i = new Intent(SearchActivity.this, BuyPremiumActivity.class);
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

        TextView textView = (TextView) findViewById(R.id.instructionSearchView);
        textView.setText("Sie suchen eine Fomel? Geben Sie den genauen Begriff ein, nur so " +
                "kann ein präzises Suchergebnis erzielt werden.");


        final EditText editText = (EditText) findViewById(R.id.inputSearchView);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText.setTypeface(null, Typeface.NORMAL);
            }
        });


        search = (Button) findViewById(R.id.searchButtonSearchView);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mText = (EditText) findViewById(R.id.inputSearchView);
                String word = mText.getText().toString();
                if (word.length() == 0) {
                    //create Alert for empty text
                    sendErrorMessage();
                } else {
                    setSearchWord(word);
                    finish();
                    Intent menu = new Intent(SearchActivity.this, ShowEntryActivity.class);
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
            finish();
            Intent menu = new Intent(SearchActivity.this, StartActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);
        }
    }
}


