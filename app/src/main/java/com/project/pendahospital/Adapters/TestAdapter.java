package com.project.pendahospital.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Activities.MakeOrderActivity;
import com.project.pendahospital.R;
import com.project.pendahospital.Models.TestModel;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    ArrayList<TestModel>list;
    Context context;

    public TestAdapter(ArrayList<TestModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.amount.setText(list.get(position).getAmount());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());
        holder.pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MakeOrderActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("amount",list.get(position).getAmount());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,amount,date,time;
        AppCompatButton pay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.prod_name);
            amount = itemView.findViewById(R.id.prod_amount);
            date = itemView.findViewById(R.id.order_date);
            time = itemView.findViewById(R.id.order_location);
            pay = itemView.findViewById(R.id.btn_pay);

        }
    }
}
