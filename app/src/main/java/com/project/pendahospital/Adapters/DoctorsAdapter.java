package com.project.pendahospital.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Patient.BookAppointmentActivity;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(@NonNull DoctorsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ConsultModel consultModel= list.get(position);
        holder.category.setText(consultModel.getDoctorCategory());
        holder.name.setText(consultModel.getDoctorName());
        holder.availability.setText(consultModel.getDoctorTime());
        Picasso.get().load(consultModel.getImageUrl()).into(holder.image);
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookAppointmentActivity.class);
                intent.putExtra("name",list.get(position).getDoctorName());
                intent.putExtra("category",list.get(position).getDoctorCategory());
                intent.putExtra("time",list.get(position).getDoctorTime());
                context.startActivity(intent);
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
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.test_name);
            category = itemView.findViewById(R.id.test_amount);
            availability = itemView.findViewById(R.id.doc_availability);
            book = itemView.findViewById(R.id.book_btn);
            image = itemView.findViewById(R.id.doc_image);
        }
    }
}
