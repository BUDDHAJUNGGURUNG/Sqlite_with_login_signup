package com.example.sqlite_with_login_signup;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        textView.setAnimation(animation);
        imageView.setAnimation(animation);

         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     sleep(900);
                     Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                     startActivity(intent);
                 }
                 catch (InterruptedException e){
                     e.printStackTrace();

                 }

             }
         });
         thread.start();
    }

    public void init(){
        textView=findViewById(R.id.txt);
        imageView=findViewById(R.id.img);
    }
}