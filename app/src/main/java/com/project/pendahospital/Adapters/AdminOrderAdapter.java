package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.TransactionModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class AdminOrderAdapter extends RecyclerView.Adapter<AdminOrderAdapter.ViewHolder> {
    Context context;
    ArrayList<TransactionModel>list;

    public AdminOrderAdapter(Context context, ArrayList<TransactionModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdminOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_admin,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminOrderAdapter.ViewHolder holder, int position) {
        holder.prod.setText(list.get(position).getProduct());
        holder.amount.setText(list.get(position).getTransactionAmount());
        holder.date.setText(list.get(position).getTransactionDate());
        holder.location.setText(list.get(position).getLocation());
        holder.phone.setText(list.get(position).getCustomerPhone());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView prod,amount,date,location,phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prod = itemView.findViewById(R.id.prod_name);
            amount = itemView.findViewById(R.id.prod_amount);
            date = itemView.findViewById(R.id.order_date);
            location = itemView.findViewById(R.id.order_location);
            phone = itemView.findViewById(R.id.cust_phone);
        }
    }
}
