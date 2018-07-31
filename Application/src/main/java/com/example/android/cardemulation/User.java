package com.example.android.cardemulation;

import com.google.firebase.database.Exclude;

public class User {

    @Exclude
    public String key;
    public String date_of_birth;
    public String full_name;
    public String activeTicket;

    public User(String dateOfBirth, String fullName) {
        date_of_birth = dateOfBirth;
        full_name = fullName;
    }

    public User() {}
}