package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText edit_email, edit_password, edit_confirm_password;
    Button btn_signup;

    TextView txt_login;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        init();
        databaseHelper= new DatabaseHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edit_email.getText().toString().trim();
                String password= edit_password.getText().toString().trim();
                String  confirm_password= edit_confirm_password.getText().toString().trim();
                boolean b= databaseHelper.insertUsers(email,password);

                if (b){
                    Toast.makeText(Signup.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(Signup.this,MainActivity.class);
                    startActivity(i);

                }else {
                    Toast.makeText(Signup.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_i=new Intent(Signup.this,Login.class);
                startActivity(login_i);
            }
        });

    }

    public  void  init  (){

        edit_email=findViewById(R.id.signup_email);
        edit_password=findViewById(R.id.signup_password);
        edit_confirm_password=findViewById(R.id.signup_confirm_password);
        btn_signup=findViewById(R.id.btn_signup);
        txt_login=findViewById(R.id.loginRedirectText);
    }
}