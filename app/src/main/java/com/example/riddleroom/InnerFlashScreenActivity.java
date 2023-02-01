package com.example.riddleroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class InnerFlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_flash_screen);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextScreen=new Intent(InnerFlashScreenActivity.this,QuizTwoActivity.class);
                startActivity(nextScreen);
                finish();
            }
        },3000);
        ImageView img;
        img=findViewById(R.id.science);
        img.animate().alpha(1).scaleXBy(0.4f).scaleYBy(1.1f).setDuration(2000);
    }
}