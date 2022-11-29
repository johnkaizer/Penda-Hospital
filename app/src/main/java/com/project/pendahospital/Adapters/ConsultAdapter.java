package com.project.pendahospital.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Activities.MakeOrderActivity;
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
    public void onBindViewHolder(@NonNull ConsultAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ConsultModel consultModel= list.get(position);
        holder.name.setText(consultModel.getDoctorName());
        holder.time.setText(consultModel.getDoctorTime());
        holder.phone.setText(consultModel.getDoctorPhone());
        Picasso.get().load(consultModel.getImageUrl()).into(holder.image);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(list.get(position).getDoctorPhone())));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone,time;
        ImageView image;
        ImageButton call;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.textView21);
            phone= itemView.findViewById(R.id.doc_phone);
            time= itemView.findViewById(R.id.doc_time);
            image = itemView.findViewById(R.id.imageView2);
            call = itemView.findViewById(R.id.phone);

        }
    }
}
