package com.example.fict.activity;


import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fict.R;
import com.example.fict.fragments.Day_fragment;

public class Gas extends AppCompatActivity  {
    Day_fragment day_fragment;

    Button day,week,mouth,year;
    Fragment frag1;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);
        day = findViewById(R.id.day);
        day_fragment = new Day_fragment();
    }




}
