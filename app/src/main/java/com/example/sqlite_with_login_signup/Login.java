package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    EditText edit_email,edit_password;
    Button btn_login;
    TextView txt_signup , txt_forgotpassword;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
        databaseHelper=new DatabaseHelper(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edit_email.getText().toString().trim();
                String password=edit_password.getText().toString().trim();

                if (email.equals("")|| password.equals("")){
                    Toast.makeText(Login.this, "All files are mandatory", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkCredentials=databaseHelper.checkEmailPassword(email,password);
                    if (checkCredentials==true){
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent loginIntent=new Intent(getApplicationContext(),Home.class);
                        startActivity(loginIntent);
                    }
                }
            }
        });
    }

    public  void  init(){
        edit_email=findViewById(R.id.login_email);
        edit_password=findViewById(R.id.login_password);
        btn_login=findViewById(R.id.btn_login);
        txt_signup=findViewById(R.id.signupRedirectText);
        txt_forgotpassword=findViewById(R.id.forgot_password);
    }
}