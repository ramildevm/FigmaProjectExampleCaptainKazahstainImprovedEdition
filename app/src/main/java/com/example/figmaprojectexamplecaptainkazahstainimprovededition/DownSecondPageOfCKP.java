package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class DownSecondPageOfCKP extends AppCompatActivity {

    float x1,x2,y1,y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_second_page_of_ckp);

        findViewById(R.id.imgGoHome).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(DownSecondPageOfCKP.this,MainActivity.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        findViewById(R.id.imgGoHomeText).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(DownSecondPageOfCKP.this,MainActivity.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        findViewById(R.id.galleryPage).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switcher=new Intent(DownSecondPageOfCKP.this,GalleryPageOfCKP.class);
                startActivity(switcher);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_down);
            }
        });
        findViewById(R.id.mainscroll).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent touchEvent) {
                switch(touchEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y1 = touchEvent.getY();
                        x1 = touchEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        y2 = touchEvent.getY();
                        x2 = touchEvent.getX();
                        float yPanel = findViewById(R.id.mainscroll).getScrollY();
                        if (x1 > x2 & Math.abs(y1-y2)<150) {
                            Intent i = new Intent(DownSecondPageOfCKP.this, DownThirdPageOfCKP.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                        else if (x1 < x2 & Math.abs(y1-y2)<150) {
                            Intent i = new Intent(DownSecondPageOfCKP.this, DownFirstPageOfCKP.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        }
                        else if (y1<y2 & yPanel==0 & Math.abs(x1-x2)<150){
                            FragmentsPage.curF = new Page2Fragment().gettag();
                            Intent intent = new Intent(DownSecondPageOfCKP.this, FragmentsPage.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_down);
                        }
                        break;
                }
                return false;
            }
        });
    }
}