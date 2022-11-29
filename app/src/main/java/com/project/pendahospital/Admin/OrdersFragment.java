package com.project.pendahospital.Admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.pendahospital.Adapters.AdminOrderAdapter;
import com.project.pendahospital.Adapters.TransactionAdapter;
import com.project.pendahospital.Models.TransactionModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {
    AdminOrderAdapter adminOrderAdapter ;
    ArrayList<TransactionModel> list;
    Query databaseReference;
    RecyclerView orderRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_orders, container, false);
        orderRv = view.findViewById(R.id.orderRv);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("TransactionDetails");
        orderRv.setHasFixedSize(true);
        orderRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        adminOrderAdapter = new AdminOrderAdapter(getContext(),list);
        orderRv.setAdapter(adminOrderAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    TransactionModel transactionModel  = dataSnapshot.getValue(TransactionModel.class);
                    list.add(transactionModel);
                }
                adminOrderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return  view;
    }
}