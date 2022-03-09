package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class FragmentsPage extends AppCompatActivity {
    float x1,x2,y1,y2;
    Page1Fragment fragment1 = new Page1Fragment();
    Page2Fragment fragment2 = new Page2Fragment();
    Page3Fragment fragment3 = new Page3Fragment();
    String curF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_page);
        curF = fragment1.gettag();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, fragment1, curF).commit();

    }
    public boolean onTouchEvent(MotionEvent event){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                if(x1 > x2 & Math.abs(y1-y2)<150) {
                    if (curF == fragment3.gettag()) {
                        break;
                    }
                    else if (curF == fragment1.gettag()){
                        curF = fragment2.gettag();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left).replace(R.id.frame_place, fragment2, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                    }
                    else if(curF == fragment2.gettag()){
                        curF = fragment3.gettag();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left).replace(R.id.frame_place, fragment3, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                    }
                }
                else if(x1 < x2 & Math.abs(y1-y2)<150) {
                    if (curF == fragment1.gettag()) {
                        break;
                    } else if (curF == fragment2.gettag()) {
                        curF = fragment1.gettag();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.frame_place, fragment1, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                    } else if (curF == fragment3.gettag()) {
                        curF = fragment2.gettag();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.frame_place, fragment2, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                    }
                }
                else if (y1>y2 & Math.abs(x1-x2)<150){

                }
                break;
        }
        return false;
    }
}