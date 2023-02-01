package com.example.riddleroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }
 public void hero_act(View view){
        Intent intent=new Intent(MainActivity.this,SuperHeroActivity.class);
        startActivity(intent);
 }

 public void science_act(View view){
        Intent intent=new Intent(MainActivity.this,ScienceActivity.class);
        startActivity(intent);
    }
    public void movie_act(View view){
        Intent intent=new Intent(MainActivity.this,MovieActivity.class);
        startActivity(intent);
    }
}