package com.example.pbt.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pbt.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        toMenu();

    }
    private void toMenu() {
        new Handler().postDelayed(
            new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, Login.class));
                    finish();
                }
            }, SPLASH_DURATION
        );
    }
}
