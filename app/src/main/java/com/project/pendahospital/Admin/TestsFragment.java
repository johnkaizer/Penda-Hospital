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
import com.project.pendahospital.Adapters.AdminTestAdapter;
import com.project.pendahospital.Models.TestModel;
import com.project.pendahospital.Models.TransactionModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class TestsFragment extends Fragment {
    AdminTestAdapter adminTestAdapter  ;
    ArrayList<TestModel> list;
    Query databaseReference;
    RecyclerView testRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tests, container, false);
        testRv = view.findViewById(R.id.tests);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("TestBookingDetails");
        testRv.setHasFixedSize(true);
        testRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        adminTestAdapter = new AdminTestAdapter(getContext(),list);
        testRv.setAdapter(adminTestAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    TestModel testModel  = dataSnapshot.getValue(TestModel.class);
                    list.add(testModel);
                }
                adminTestAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }
}