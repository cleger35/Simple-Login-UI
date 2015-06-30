package com.example.cleger.customloginform;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    // UI references
    EditText email;
    EditText password;


    // ArrayList to hold the users
    public ArrayList<User> users = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);

        Button signInButton = (Button) findViewById(R.id.btnSignIn);
        Button registerButton = (Button) findViewById(R.id.btnRegister);
        users.add(new User("test", "test"));

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uInput = email.getText().toString();
                String pInput = password.getText().toString();

                boolean found = false;
                for (User u : users) {
                    if (uInput.equals(u.email) && pInput.equals(u.password)) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    Toast.makeText(getApplicationContext(), "Invalid credentials.", Toast
                            .LENGTH_SHORT).show();
                else {
                        Intent myIntent = new Intent(MainActivity.this, SuccessActivity.class);
                        myIntent.putExtra("username", uInput);
                        myIntent.putExtra("password", pInput);
                        MainActivity.this.startActivity(myIntent);
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uInput = email.getText().toString();
                String pInput = password.getText().toString();
                users.add(new User(uInput, pInput));
                Toast.makeText(getApplicationContext(), "New username: " + uInput, Toast
                        .LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
