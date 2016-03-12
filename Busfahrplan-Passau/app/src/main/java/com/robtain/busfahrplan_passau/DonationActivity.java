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
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by RobTain on 12.03.2016.
 */
public class DonationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation);

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
                        Intent i = new Intent(DonationActivity.this, tools
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
        TextView textView = (TextView) findViewById(R.id.donationText);


        String value = "<html> <p>Die App ist völlig gratis, es gibt keine " +
                "Werbung oder versteckten Videos, um Geldeinnahmen zu generieren. " +
                "Dadurch, dass die App keinerlei Rechte braucht und somit " +
                "komplett Offline genutzt werden kann, gibt es auch keine " +
                "Möglichkeit, Tricks einzubauen. Das ist zum jetzigen Zeitpunkt " +
                "so und es wird auch immer so bleiben.</p>" +
                "<p>Dennoch hat die App im Erstellungsprozess Geld und Nerven" +
                " gekostet. Insgesamt habe ich 55 Arbeitsstunden in diese App" +
                " investiert. Berechnet man dies mit einem sehr niedrigen " +
                "Stundenlohn (12 Euro), so wären es 660 Euro. Weiterhin " +
                "sollte man die Stromkosten in der heutigen Zeit nicht " +
                "außer Acht lassen. Dementsprechend käme die App zirka " +
                "auf 700 Euro. Letztendlich fehlt nur noch die Gebühr von 25 " +
                "$, damit man überhaupt auf dem Play Store Apps " +
                "veröffentlichen kann. </p>" +
                "<p>Lange Rede, kurzer Sinn, die App kostet euch nichts, " +
                "aber ich würde mich über jede einzelne Spende freuen.</p>" +
                "<p><a href=\"https://www.paypal" +
                ".com/cgi-bin/webscr?cmd=_donations&business=ragingrobert" +
                "2508%40gmail%2ecom&lc=DE&item_name=Busfahrplan%2dPassau&no_" +
                "note=1&no_shipping=1&currency_code=EUR&bn=PP%2dDonationsBF%" +
                "3abtn_donateCC_LG%2" +
                "egif%3aNonHosted\">Spendenlink</a> </html>";
        TextView text = (TextView) findViewById(R.id.donationText);
        text.setText(Html.fromHtml(value));
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}