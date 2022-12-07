package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdminDoctorsAdapter extends RecyclerView.Adapter<AdminDoctorsAdapter.ViewHolder> {
    Context context;
    ArrayList<ConsultModel>list;

    public AdminDoctorsAdapter(Context context, ArrayList<ConsultModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdminDoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_manage_item,parent,false));

    }
    @Override
    public void onBindViewHolder(@NonNull AdminDoctorsAdapter.ViewHolder holder, int position) {
        ConsultModel consultModel= list.get(position);
        holder.category.setText(consultModel.getDoctorCategory());
        holder.name.setText(consultModel.getDoctorName());
        holder.time.setText(consultModel.getDoctorTime());
        holder.phone.setText(consultModel.getDoctorPhone());
        holder.number.setText(consultModel.getDocNumber());
        Picasso.get().load(consultModel.getImageUrl()).into(holder.image);
        holder.flow_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String ID = list.get(holder.getAdapterPosition()).getDocNumber();
             FirebaseDatabase.getInstance().getReference().child("DoctorsDetails")
                     .child(ID)
                     .getRef().removeValue()
                     .addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {
                             Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                         }
                     });
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageButton flow_menu;
        TextView name, number,phone,category,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_txt);
            flow_menu = itemView.findViewById(R.id.flow_menu);
            name = itemView.findViewById(R.id.test_name);
            number = itemView.findViewById(R.id.doc_number);
            phone = itemView.findViewById(R.id.doc_phone);
            category = itemView.findViewById(R.id.doc_cat);
            time = itemView.findViewById(R.id.doc_time);


        }
    }
}
