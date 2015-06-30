package com.example.cleger.customloginform;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the activity that will begin after a successful login.
 */

public class SuccessActivity extends ActionBarActivity {
    TextView email;
    TextView pword;
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        email = (TextView) findViewById(R.id.tvEmail);
        pword = (TextView) findViewById(R.id.tvPWord);

        Bundle extras = getIntent().getExtras();

        // Retrieve the credentials from the login activity
        if (extras.containsKey("username"))
            username = extras.getString("username");
        if (extras.containsKey("password"))
            password = extras.getString("password");

        // Display the credentials for the new user
        email.setText("Username: " + username);
        pword.setText("Password: " + password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_success, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
