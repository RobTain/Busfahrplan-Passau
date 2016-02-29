package formula.freeversion;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RobTain on 29.01.2016.
 */
public class BuyPremiumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buyPremium();

    }

    public void buyPremium() {
        try {
            Intent rateIntent = rateIntentForUrl("http://play.google" +
                    ".com/store/apps/");
            startActivity(rateIntent);
        } catch (ActivityNotFoundException e) {
            Intent rateIntent = rateIntentForUrl("http://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }

    private Intent rateIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21) {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        } else {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(BuyPremiumActivity.this, StartActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);

        }
    }
}


