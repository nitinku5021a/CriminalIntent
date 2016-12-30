package com.gunuchi.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by nitin on 28/12/16.
 */

public class Crime {
    private String mTitle;
    private UUID mId;
    private Date mDate;
    private Boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public void setmTitle(String title){
        this.mTitle = title;
    }
    public String getmTitle(){
        return mTitle;
    }
    public UUID getmId(){
        return mId;
    }
    public Date getmDate(){
        return mDate;
    }
    public void setmDate(Date date){
        this.mDate = date;
    }
    public void setmSolved(Boolean solved){
        this.mSolved = solved;
    }
    public Boolean getmSolved(){
        return mSolved;
    }
}
