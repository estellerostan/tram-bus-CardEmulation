package com.example.android.domaindata;

import com.google.firebase.database.Exclude;

public class User {

    @Exclude
    private String key;
    private String date_of_birth;
    private String full_name;
    private String activeTicket;

    public User(String dateOfBirth, String fullName) {
        date_of_birth = dateOfBirth;
        full_name = fullName;
    }

    public User() {}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActiveTicket() {
        return activeTicket;
    }

    public void setActiveTicket(String activeTicket) {
        this.activeTicket = activeTicket;
    }
}