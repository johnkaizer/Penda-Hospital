package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {

    Context context;
    ArrayList<ConsultModel>list;

    public DoctorsAdapter(Context context, ArrayList<ConsultModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.ViewHolder holder, int position) {
        holder.category.setText(list.get(position).getDoctorCategory());
        holder.name.setText(list.get(position).getDoctorName());
        holder.availability.setText(list.get(position).getDoctorTime());
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, category, availability;
        Button book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.doc_name);
            category = itemView.findViewById(R.id.doc_category);
            availability = itemView.findViewById(R.id.doc_availability);
            book = itemView.findViewById(R.id.book_btn);
        }
    }
}
