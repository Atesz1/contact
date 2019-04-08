package com.example.contactlist;

import android.telephony.SignalStrength;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private int mId;
    private String fullname;
    private String company;
    private String title;
    private String mobile;
    private String email;
    private String created;
    private String avatar;

    public Contact(){}

    public Contact(int mId, String fullname, String company, String title, String mobile, String email) {
        this.fullname = fullname;
        this.company = company;
        this.title = title;
        this.mobile = mobile;
        this.email = email;
        this.mId = mId;
    }
    public int getmId() {return mId;}

    public void setmId(int mId) {this.mId=mId;}

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}
