package com.example.fict.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fict.R;
import com.example.fict.fragments.Day_fragment;
import com.example.fict.fragments.Month_fragment;
import com.example.fict.fragments.Week_fragment;
import com.example.fict.fragments.Year_fragment;

import java.util.Date;

import static com.example.fict.MainActivity.getTEMPEARTURE;

public class Temperature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        TextView textView = findViewById(R.id.textView5);
        Date date = new Date();
        TextView textView1 = findViewById(R.id.Date);
        textView1.setText(date.toString());
        textView.setText(getTEMPEARTURE());
    }
    @SuppressLint("ShowToast")
    public void Change(View view){
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.day:
                fragment = new Day_fragment();
                Toast.makeText(getApplicationContext(),"Open a fragmant 1",Toast.LENGTH_LONG).show();

                break;
            case R.id.week:
                fragment = new Week_fragment();

                Toast.makeText(getApplicationContext(),"Open a fragmant 2",Toast.LENGTH_LONG).show();
                break;
            case R.id.month:
                fragment = new Month_fragment();

                Toast.makeText(getApplicationContext(),"Open a fragmant 3",Toast.LENGTH_LONG).show();
                break;
            case R.id.year:
                fragment = new Year_fragment();
                Toast.makeText(getApplicationContext(),"Open a fragmant 4",Toast.LENGTH_LONG).show();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,fragment);
        ft.commit();
    }
}
