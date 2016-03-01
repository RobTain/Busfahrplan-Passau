package com.robtain.busfahrplan_passau;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by RobTain on 29.01.2016.
 */
public class ContactActivity extends AppCompatActivity {
    String contactTitle;
    private String contactText;
    private Button contactMail;
    //ToDO hier noch eine richtige Emailadresse einfÃ¼gen!!!
    private String[] recipients = new String[]{"ragingrobert2508@gmail.com", ""};
    private boolean notSend = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);



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

                        // Handle navigation view item clicks here.
                        int id = item.getItemId();
                        Intent i;

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    private void openView(Intent i) {
                        finish();
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        startActivity(i);
                    }


                });

        //settings editTitle
        final EditText editText = (EditText) findViewById(R.id.contactTitle);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText.setTypeface(null, Typeface.NORMAL);
            }
        });

        TextView textView = (TextView) findViewById(R.id.contactText);
        textView.setMovementMethod(new ScrollingMovementMethod());

        // hide keyboard after writing something into the @id/contactText
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id
                .contactLayout);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager manager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(getWindow().getCurrentFocus()
                        .getWindowToken(),0);
                return false;
            }
        });

        //settings contact Button
        contactMail = (Button) findViewById(R.id.contactButton);
        contactMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                // set email adress
                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
                // set email title
                EditText mText = (EditText) findViewById(R.id.contactTitle);
                contactTitle = mText.getText().toString();
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, contactTitle);
                // set email text
                mText = (EditText) findViewById(R.id.contactText);
                contactText = mText.getText().toString();
                // you cant send an email without text
                if (contactText.length() != 0) {
                    emailIntent.putExtra(Intent.EXTRA_TEXT, contactText);
                } else {
                    notSend = true;
                }
                emailIntent.setType("text/plain");

                //create Alert for empty text or send email
                if (notSend) {
                    sendErrorMessage();
                } else {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                }

            }
        });
    }

    /**
     * create error message (empty request)
     */
    private void sendErrorMessage() {
        AlertDialog.Builder messageMissingInput = new AlertDialog.Builder(this);
        messageMissingInput.setTitle("Fehlende Eingabe...");
        messageMissingInput.setMessage("Bitte geben Sie einen Text ein, bevor Sie fortfahren!");
        messageMissingInput.setNeutralButton("OK", null);
        messageMissingInput.setIcon(R.drawable.warning);
        messageMissingInput.show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            Intent menu = new Intent(ContactActivity.this, StartActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(menu);

        }
    }

}
