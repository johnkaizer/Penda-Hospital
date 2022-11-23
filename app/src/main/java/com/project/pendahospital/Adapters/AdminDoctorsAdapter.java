package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
            name = itemView.findViewById(R.id.doc_name);
            number = itemView.findViewById(R.id.doc_number);
            phone = itemView.findViewById(R.id.doc_phone);
            category = itemView.findViewById(R.id.doc_cat);
            time = itemView.findViewById(R.id.doc_time);


        }
    }
}
