package com.gunuchi.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CriminalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new CrimeFragment();
        fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
}
