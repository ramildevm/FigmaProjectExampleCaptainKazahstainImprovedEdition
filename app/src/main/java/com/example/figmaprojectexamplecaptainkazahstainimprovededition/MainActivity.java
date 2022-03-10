package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goToPage1(View v){
        Bundle bundle = null;
        Pair<View, String> pair1 = Pair.create(findViewById(R.id.imgGoHome), findViewById(R.id.imgGoHome).getTransitionName());

        ActivityOptions options;
        options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pair1);
        bundle = options.toBundle();
        FragmentsPage.curF = new Page1Fragment().gettag();
        Intent intent = new Intent(this,FragmentsPage.class);
        startActivity(intent, bundle);
    }
}