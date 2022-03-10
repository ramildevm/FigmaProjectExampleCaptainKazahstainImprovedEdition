package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class FragmentsPage extends AppCompatActivity {
    float x1,x2,y1,y2;
    Page1Fragment fragment1 = new Page1Fragment();
    Page2Fragment fragment2 = new Page2Fragment();
    Page3Fragment fragment3 = new Page3Fragment();
    static String curF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_page);
        if(curF==fragment1.gettag()){
            setScene(fragment1,ContextCompat.getDrawable(this,R.drawable.background_set1));
        }
        else if(curF==fragment2.gettag()){
            setScene(fragment2,ContextCompat.getDrawable(this,R.drawable.background_set2));
        }
        else if(curF==fragment3.gettag()){
            setScene(fragment3,ContextCompat.getDrawable(this,R.drawable.background_set3));
        }

    }
    private void setScene(Fragment f, Drawable d){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, f, curF).commit();
        findViewById(R.id.parentBackLayout).setBackground(d);
    }
    public boolean onTouchEvent(MotionEvent event){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TransitionDrawable transition;
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
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set1));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, fragment2, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(200);
                    }
                    else if(curF == fragment2.gettag()){
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set2));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        curF = fragment3.gettag();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, fragment3, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(200);
                    }
                }
                else if(x1 < x2 & Math.abs(y1-y2)<150) {
                    if (curF == fragment1.gettag()) {
                        break;
                    } else if (curF == fragment2.gettag()) {
                        curF = fragment1.gettag();
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set4));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, fragment1, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(200);
                    } else if (curF == fragment3.gettag()) {
                        curF = fragment2.gettag();
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set3));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        transition.startTransition(200);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_place, fragment2, curF).commit();
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