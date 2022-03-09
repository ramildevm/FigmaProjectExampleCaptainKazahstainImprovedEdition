package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Page3Fragment extends Fragment {

    private String tag = "THIRD_FRAGMENT";
    public String gettag(){
        return tag;
    }
    public boolean IsLeft = true;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Transition left = TransitionInflater.from(getContext()).inflateTransition(R.transition.slide_out_left);
        Transition right = TransitionInflater.from(getContext()).inflateTransition(R.transition.slide_in_left);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
            if(IsLeft) {
                setEnterTransition(right);
                setExitTransition(left);
            }
            else{
                setEnterTransition(left);
                setExitTransition(right);
            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page3, container, false);
    }
}