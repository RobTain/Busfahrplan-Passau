package com.robtain.busfahrplan_passau;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RobTain on 29.01.2016.
 */
public class RateAppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rateApp();

    }

    @SuppressLint("LongLogTag")
    public void rateApp() {
            String url = "https://play.google.com/store/apps/details?id=" +
                    getPackageName();
            Intent rate = new Intent(Intent.ACTION_VIEW);
            rate.setData(Uri.parse(url));
            startActivity(rate);
        }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(RateAppActivity.this, StartActivity.class);
            startActivity(menu);

        }
    }
}


