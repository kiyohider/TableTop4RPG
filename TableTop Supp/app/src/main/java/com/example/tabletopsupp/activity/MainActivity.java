package com.example.tabletopsupp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tabletopsupp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PlayerPage(View view) {
        Intent intent = new Intent(getApplicationContext(),GameMasterNavigation.class);
        startActivity(intent);
    }

}