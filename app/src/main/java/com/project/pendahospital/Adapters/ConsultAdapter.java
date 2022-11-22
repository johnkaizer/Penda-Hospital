package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.Patient.EconsultActivity;
import com.project.pendahospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.ViewHolder> {
    Context context;
    ArrayList<ConsultModel>list;

    public ConsultAdapter(Context context, ArrayList<ConsultModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ConsultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_consult_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ConsultAdapter.ViewHolder holder, int position) {
        ConsultModel consultModel= list.get(position);
        holder.name.setText(consultModel.getDoctorName());
        holder.time.setText(consultModel.getDoctorTime());
        holder.phone.setText(consultModel.getDoctorPhone());
        Picasso.get().load(consultModel.getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone,time;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.textView21);
            phone= itemView.findViewById(R.id.doc_phone);
            time= itemView.findViewById(R.id.doc_time);
            image = itemView.findViewById(R.id.imageView2);
        }
    }
}
