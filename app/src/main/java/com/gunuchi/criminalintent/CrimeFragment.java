package com.gunuchi.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mEditText;
    private Button mButton;
    private CheckBox isSolved;

    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID mId = (UUID) getActivity().getIntent().getSerializableExtra("EXTRA_CRIME_ID");
        mCrime = CrimeLab.get(getActivity()).getCrime(mId);
        //mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_crime, container, false);
        mEditText = (EditText) v.findViewById(R.id.editText);
        mEditText.setText(mCrime.getmTitle());
        mButton = (Button) v.findViewById(R.id.DateButton);
        mButton.setText(mCrime.getmDate().toString());
        mButton.setEnabled(false);

        isSolved = (CheckBox) v.findViewById(R.id.isSolved);
        isSolved.setChecked(mCrime.getmSolved());
        isSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }

}
