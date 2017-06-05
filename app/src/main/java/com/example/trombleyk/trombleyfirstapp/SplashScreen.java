package com.example.trombleyk.trombleyfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    //Runs splash screen for 4000 milliseconds
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //Runs splash screen
        myThread.start();
        //Code for splash screen
        //https://github.com/humayuntorab/Splash-Screen/blob/master/app/src/main/java/com/example/torab/splashscreen/SplashScreen.java
    }
}