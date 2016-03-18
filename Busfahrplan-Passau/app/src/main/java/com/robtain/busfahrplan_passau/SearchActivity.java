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
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;

public class SearchActivity extends AppCompatActivity {
    private LinkedList<BusStation> searchList;
    private Tools tools;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.search);

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
                            Intent i = new Intent(SearchActivity.this, tools
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
                         *
                         * @param i
                         */
                        private void openView(Intent i) {
                            finish();
                            startActivity(i);
                        }
                    });

            final EditText editText = (EditText) findViewById(R.id.searchInput);
            editText.getBackground().setColorFilter(getResources().getColor(R.color.swp_blue),
                    PorterDuff.Mode
                            .SRC_IN);
            Button button = (Button) findViewById(R.id.searchButton);
            tools = new Tools();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Editable input = editText.getText();
                    String enteredInput = input.toString();
                    if (enteredInput != null) {
                        tools.search(enteredInput);
                        Intent i = new Intent(SearchActivity.this,
                                FoundSearchActivity.class);
                        i.putExtra("search", tools);
                        finish();
                        startActivity(i);
                    }
                }
            });
        }

    /**
     * return to startActivity
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent i = new Intent(SearchActivity.this, StartActivity.class);
            startActivity(i);
        }
    }


}

