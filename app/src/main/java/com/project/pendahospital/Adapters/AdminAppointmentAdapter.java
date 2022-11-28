package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.AppointmentModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class AdminAppointmentAdapter extends RecyclerView.Adapter<AdminAppointmentAdapter.ViewHolder> {

    Context context;
    ArrayList<AppointmentModel>list;

    public AdminAppointmentAdapter(Context context, ArrayList<AppointmentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdminAppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_appointment,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdminAppointmentAdapter.ViewHolder holder, int position) {
        holder.doctor.setText(list.get(position).getDocName());
        holder.category.setText(list.get(position).getDocCategory());
        holder.name.setText(list.get(position).getPatName());
        holder.phone.setText(list.get(position).getPatPhone());
        holder.time.setText(list.get(position).getPatTime());
        holder.date.setText(list.get(position).getPatDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView doctor,category, name,time,date,phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor = itemView.findViewById(R.id.test_name);
            category = itemView.findViewById(R.id.doc_cat);
            name = itemView.findViewById(R.id.pat_name);
            time = itemView.findViewById(R.id.pat_time);
            date = itemView.findViewById(R.id.pat_date);
            phone = itemView.findViewById(R.id.pat_name);

        }
    }
}
