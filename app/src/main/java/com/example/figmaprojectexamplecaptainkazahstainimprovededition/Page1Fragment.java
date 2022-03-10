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

public class Page1Fragment extends Fragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            left = TransitionInflater.from(getContext()).inflateTransition(R.transition.slide_out_left);
            right = TransitionInflater.from(getContext()).inflateTransition(R.transition.slide_in_left);
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
            setEnterTransition(right);
            setExitTransition(left);
        }
    }
    Transition left;
    Transition right;
    private String tag = "FIRST_FRAGMENT";
    public String gettag(){
        return tag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_page1, container, false);
    }
    public void setLeft(){
        setEnterTransition(right);
        setExitTransition(left);
    }
    public void setRight(){
        setEnterTransition(left);
        setExitTransition(right);
    }
}