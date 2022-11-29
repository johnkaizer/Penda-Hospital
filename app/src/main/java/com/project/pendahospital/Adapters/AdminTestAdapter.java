package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.TestModel;
import com.project.pendahospital.Models.TransactionModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class AdminTestAdapter extends RecyclerView.Adapter<AdminTestAdapter.ViewHolder> {

    Context context;
    ArrayList<TestModel>list;

    public AdminTestAdapter(Context context, ArrayList<TestModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdminTestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_admin,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminTestAdapter.ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.amount.setText(list.get(position).getAmount());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());
        holder.patient.setText(list.get(position).getPatName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,amount,date,time,patient;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.prod_name);
            amount = itemView.findViewById(R.id.prod_amount);
            date = itemView.findViewById(R.id.order_date);
            time = itemView.findViewById(R.id.order_location);
            patient = itemView.findViewById(R.id.patient);
        }
    }
}
