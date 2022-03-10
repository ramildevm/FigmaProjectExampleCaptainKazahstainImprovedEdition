package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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
        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set1));
        findViewById(R.id.imgGoHome).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(FragmentsPage.this,MainActivity.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        findViewById(R.id.imgGoHomeText).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(FragmentsPage.this,MainActivity.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        findViewById(R.id.galleryPage).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(FragmentsPage.this,GalleryPageOfCKP.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_down);
            }
        });

    }
    public boolean onTouchEvent(MotionEvent event){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TransitionDrawable transition;
        int animTime = 400;
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
                        fragment2.setLeft();
                        fragment1.setLeft();
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set1));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        getSupportFragmentManager().beginTransaction().addSharedElement(findViewById(R.id.button1),"button_transition").replace(R.id.frame_place, fragment2, curF).addToBackStack(null).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(animTime);
                    }
                    else if(curF == fragment2.gettag()){
                        fragment3.setLeft();
                        fragment2.setLeft();
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set2));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        curF = fragment3.gettag();
                        getSupportFragmentManager().beginTransaction().addSharedElement(findViewById(R.id.button1),"button_transition").addToBackStack(null).replace(R.id.frame_place, fragment3, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(animTime);
                    }
                }
                else if(x1 < x2 & Math.abs(y1-y2)<150) {
                    if (curF == fragment1.gettag()) {
                        break;
                    } else if (curF == fragment2.gettag()) {
                        fragment2.setRight();
                        fragment1.setRight();
                        curF = fragment1.gettag();
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set4));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        getSupportFragmentManager().beginTransaction().addSharedElement(findViewById(R.id.button1),"button_transition").addToBackStack(null).replace(R.id.frame_place, fragment1, curF).commit();
                        ft.remove(getSupportFragmentManager().findFragmentById(R.id.frame_place)).commit();
                        transition.startTransition(animTime);
                    } else if (curF == fragment3.gettag()) {
                        fragment3.setRight();
                        fragment2.setRight();
                        curF = fragment2.gettag();
                        fragment3.IsLeft = false;
                        findViewById(R.id.parentBackLayout).setBackground(ContextCompat.getDrawable(this,R.drawable.background_set3));
                        transition = (TransitionDrawable) findViewById(R.id.parentBackLayout).getBackground();
                        transition.startTransition(animTime);
                        getSupportFragmentManager().beginTransaction().addSharedElement(findViewById(R.id.button1),"button_transition").addToBackStack(null).replace(R.id.frame_place, fragment2, curF).commit();
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