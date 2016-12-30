package com.gunuchi.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeList;
    private CrimeAdapter crimeAdapter;
    public CrimeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeList = (RecyclerView) v.findViewById(R.id.CrimeList);
        mCrimeList.setLayoutManager(new LinearLayoutManager(getActivity()));
        UpdateUI();

        return v;
    }

    private void UpdateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getmCrimes();

        crimeAdapter = new CrimeAdapter(crimes);
        mCrimeList.setAdapter(crimeAdapter);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Crime mCrime;
        public TextView mTitleTextView;
        public TextView mDateView;
        public CheckBox mCheckBox;

        public void bindCrime(Crime crime){
            this.mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateView.setText(mCrime.getmDate().toString());
            mCheckBox.setChecked(mCrime.getmSolved());
        }

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.TitleText_list);
            mDateView = (TextView) itemView.findViewById(R.id.Date_list);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox_list);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getActivity(), CriminalActivity.class);
            intent.putExtra("EXTRA_CRIME_ID",mCrime.getmId());
            startActivity(intent);

        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> Crimes){
            mCrimes = Crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_crime_single, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

}
