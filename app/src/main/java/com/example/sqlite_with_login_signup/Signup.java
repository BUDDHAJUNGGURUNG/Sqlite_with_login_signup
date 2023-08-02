package com.example.sqlite_with_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite_with_login_signup.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.signupEmail.getText().toString().trim();
                String password=binding.signupPassword.getText().toString().trim();
                String cpassword=binding.signupConfirmPassword.getText().toString().trim();

                if (email.equals("") || password.equals("")|| cpassword.equals(""))
                    Toast.makeText(Signup.this,"All field are mandatory",Toast.LENGTH_SHORT).show();
                else{
                    if (password.equals(cpassword)){
                        Boolean checkEmail=databaseHelper.checkEmail(email);
                        if (checkEmail==false){
                            Boolean insert=databaseHelper.insertUsers(email,password);
                            if (insert==true){
                                Toast.makeText(Signup.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(Signup.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Signup.this,"Users already exists please Login",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Signup.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}