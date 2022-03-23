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
    Transition left;
    Transition right;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page3, container, false);
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