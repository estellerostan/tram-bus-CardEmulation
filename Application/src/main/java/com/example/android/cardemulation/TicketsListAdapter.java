package com.example.android.cardemulation;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicketsListAdapter implements ListAdapter {

    public static final String USERS_TABLE = "users";

    private ArrayList<Ticket> tikcets;

    public TicketsListAdapter() {

        tikcets = new ArrayList<>();

//        if () { // dummy data
        Ticket e1 = new Ticket("Pass 1 jour", "Prenez n'importe quel transport en commun du réseau TramBus de votre ville pendant une journée.");
        Ticket e2 = new Ticket("Ticket Solo", "");
        Ticket e3 = new Ticket("Ticket 10 trajets", "");

        tikcets.add(e2);
        tikcets.add(e1);
        tikcets.add(e3);
//        }
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return tikcets.size();
    }

    @Override
    public Ticket getItem(int position) {
        return tikcets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View returnView;

        if (convertView == null) {
            Context context = parent.getContext();
            returnView = View.inflate(context, R.layout.activity_ticket_view, null);
        }
        else {
            returnView = convertView;
        }
        TextView nom = returnView.findViewById(R.id.nom);
        nom.setText(tikcets.get(position).getName());

        TextView desc = returnView.findViewById(R.id.description);
        desc.setText(tikcets.get(position).getDescription());

        ImageView image = returnView.findViewById(R.id.icon);

        Button shareBtn = returnView.findViewById(R.id.share);
        shareBtn.setVisibility(View.VISIBLE);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USERS_TABLE).child(user.getUid()).getRef();

                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                if (position >= 0) {
                    Ticket o = getItem(position);

                    Map<String, Object> userUpdates = new HashMap<>();
                    userUpdates.put("activeTicket", o.getName());

                    ref.updateChildren(userUpdates);

                    Toast.makeText(v.getContext(), "Ticket acheté !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return returnView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        if (tikcets.isEmpty()){
            return true;
        }
        return false;
    }

    public ArrayList<Ticket> getTikcets() {
        return tikcets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        tikcets = tickets;
    }

    public void addTicket(Ticket t)
    {
        tikcets.add(t);
    }
}
