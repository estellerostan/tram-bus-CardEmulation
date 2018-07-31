package com.example.android.cardemulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicketView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view);

        Button shareBtn = findViewById(R.id.share);
        shareBtn.setVisibility(View.VISIBLE);
    }
}
