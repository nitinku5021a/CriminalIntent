package com.gunuchi.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by nitin on 28/12/16.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab==null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public List<Crime> getmCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime:mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
    private CrimeLab(Context context){
        Random random = new Random();


        mCrimes = new ArrayList<>();
        for(int i=0; i<=100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #"+i);
            crime.setmSolved(random.nextInt(100)%2==0);

            mCrimes.add(crime);
        }
    }
}
