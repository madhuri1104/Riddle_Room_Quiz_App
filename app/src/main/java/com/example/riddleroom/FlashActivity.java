package com.example.riddleroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class FlashActivity extends AppCompatActivity {
    ImageView logo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        getSupportActionBar().hide();

        logo1=findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               logo1.animate().rotation(2000).alpha(1).setDuration(3000);
                Intent nextScreen=new Intent(FlashActivity.this,MainActivity.class);
                startActivity(nextScreen);
                finish();
            }
        },3000);

    }
}