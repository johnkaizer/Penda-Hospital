package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.PharmacyModel;
import com.project.pendahospital.Patient.PhamarcyActivity;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolder> {

    public PharmacyAdapter(Context context, ArrayList<PharmacyModel> list, PhamarcyActivity phamarcyActivity) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<PharmacyModel> list;
    @NonNull
    @Override
    public PharmacyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacy_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PharmacyAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.num.setText(list.get(position).getNumber());
        holder.content.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView num,content;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView4);
            num = itemView.findViewById(R.id.number);
            content = itemView.findViewById(R.id.content1);
        }
    }
}
