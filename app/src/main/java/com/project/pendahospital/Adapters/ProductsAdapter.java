package com.project.pendahospital.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Activities.MakeOrderActivity;
import com.project.pendahospital.Models.ProductsModel;
import com.project.pendahospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public ProductsAdapter(Context context, ArrayList<ProductsModel> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<ProductsModel>list;

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wellness_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ProductsModel productsModel= list.get(position);
        holder.title.setText(productsModel.getProductName());
        holder.amount.setText(productsModel.getProductAmount());
        Picasso.get().load(productsModel.getImageUrl()).into(holder.image);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MakeOrderActivity.class);
                intent.putExtra("title",list.get(position).getProductName());
                intent.putExtra("amount",list.get(position).getProductAmount());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount,title;
        ImageView image;
        ImageButton add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView7);
            title= itemView.findViewById(R.id.textView15);
            amount = itemView.findViewById(R.id.textView16);
            add= itemView.findViewById(R.id.add_btn);
        }
    }
}
