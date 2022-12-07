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
import com.project.pendahospital.Adapters.AdminAppointmentAdapter;
import com.project.pendahospital.Adapters.DoctorsAdapter;
import com.project.pendahospital.Models.AppointmentModel;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;

import java.util.ArrayList;


public class AppointmentFragment extends Fragment {
    AdminAppointmentAdapter adminAppointmentAdapter;
    ArrayList<AppointmentModel> list;
    RecyclerView appointmentRec;
    Query databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_appointment, container, false);
        appointmentRec=view.findViewById(R.id.appointments);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("BookingDetails");
        appointmentRec.setHasFixedSize(true);
        appointmentRec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        adminAppointmentAdapter = new AdminAppointmentAdapter(getContext(),list);
        appointmentRec.setAdapter(adminAppointmentAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    AppointmentModel appointmentModel = dataSnapshot.getValue(AppointmentModel.class);
                    list.add(appointmentModel);
                }
                adminAppointmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       return view;

    }

}