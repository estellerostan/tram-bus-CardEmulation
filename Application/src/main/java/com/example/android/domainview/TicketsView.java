package com.example.android.domainview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.cardemulation.R;

public class TicketsView extends AppCompatActivity {

    private ListView ticketsList;
    private TicketsListAdapter data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_view);

        ticketsList = findViewById(R.id.ticketsList);
        ticketsList.invalidateViews();

        data = new TicketsListAdapter();

        ticketsList.setAdapter(data);
    }
}
