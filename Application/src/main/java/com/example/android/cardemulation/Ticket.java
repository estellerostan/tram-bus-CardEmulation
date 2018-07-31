package com.example.android.cardemulation;

import java.util.Date;

public class Ticket {
    private String name;
    private String description;

    public Ticket() {}

    public Ticket(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
