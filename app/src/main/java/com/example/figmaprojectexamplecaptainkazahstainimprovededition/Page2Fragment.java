package com.example.figmaprojectexamplecaptainkazahstainimprovededition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Page2Fragment extends Fragment {
    private String tag = "SECOND_FRAGMENT";
    public String gettag(){
        return tag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2, container, false);
    }
}