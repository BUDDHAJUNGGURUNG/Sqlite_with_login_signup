package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {
        Intent LoginIntent= new Intent(getApplicationContext(),Login.class);
        startActivity(LoginIntent);

    }

    public void Signup(View view) {
        Intent SignupIntent= new Intent(getApplicationContext(),Signup.class);
        startActivity(SignupIntent);
    }
}