package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.InsuranceModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.ViewHolder> {
    Context context;
    ArrayList<InsuranceModel>list;

    public InsuranceAdapter(Context context, ArrayList<InsuranceModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InsuranceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getPatName());
        holder.number.setText(list.get(position).getPatNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_pat);
            number = itemView.findViewById(R.id.member_no);

        }
    }
}
