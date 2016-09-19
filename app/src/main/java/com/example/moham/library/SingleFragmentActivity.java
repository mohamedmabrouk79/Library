package com.example.moham.library;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by moham on 18/09/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment CreateFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libary);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.Fragment_Container);

        if (fragment==null){
            fragment=CreateFragment();

            fragmentManager.beginTransaction().add(R.id.Fragment_Container,fragment).commit();
        }
    }
}
