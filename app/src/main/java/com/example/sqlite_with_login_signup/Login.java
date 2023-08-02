package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite_with_login_signup.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding=ActivityLoginBinding.inflate(getLayoutInflater());

        databaseHelper=new DatabaseHelper(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.loginEmail.getText().toString().trim();
                String password=binding.loginPassword.getText().toString().trim();
                if (email.equals("")|| password.equals(""))
                    Toast.makeText(Login.this,"All field are mandatory",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredential=databaseHelper.checkEmailPassword(email,password);
                    if (checkCredential==true){
                        Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this,"Invalid Credential",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}