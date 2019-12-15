package com.teamscam.localhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.teamscam.localhub.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setStatusBarColor(Color.parseColor("#0497E7"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CountDownTimer countDownTimer=new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long l)
            {
            }

            @Override
            public void onFinish()
            {
                Intent myIntent = new Intent(SplashScreen.this, LoginActivity.class);
                SplashScreen.this.startActivity(myIntent);
            }
        }.start();
    }
}
