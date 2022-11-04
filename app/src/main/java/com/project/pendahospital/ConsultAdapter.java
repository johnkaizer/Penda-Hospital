package com.project.pendahospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Adapters.HealthAdapter;
import com.project.pendahospital.Patient.EconsultActivity;

import java.util.ArrayList;
import java.util.List;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.ViewHolder> {
    Context context;
    ArrayList<ConsultModel>list;

    public ConsultAdapter(Context context, ArrayList<ConsultModel> list, EconsultActivity econsultActivity) {
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
        holder.name.setText(list.get(position).getDoctorName());
        holder.time.setText(list.get(position).getDoctorTime());
        holder.phone.setText(list.get(position).getDoctorPhone());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.textView21);
            phone= itemView.findViewById(R.id.doc_phone);
            time= itemView.findViewById(R.id.doc_time);
        }
    }
}
