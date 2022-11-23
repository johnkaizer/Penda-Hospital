package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.Models.ProductsModel;
import com.project.pendahospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductManAdapter extends RecyclerView.Adapter<ProductManAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductsModel>list;

    public ProductManAdapter(Context context, ArrayList<ProductsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductManAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.prod_management, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductManAdapter.ViewHolder holder, int position) {
        ProductsModel productsModel= list.get(position);
        holder.name.setText(productsModel.getProductName());
        holder.amount.setText(productsModel.getProductAmount());
        holder.description.setText(productsModel.getProductDescription());
        Picasso.get().load(productsModel.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageButton flow_menu;
        TextView name,amount,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_txt);
            flow_menu = itemView.findViewById(R.id.flow_menu);
            name = itemView.findViewById(R.id.prod_name);
            amount = itemView.findViewById(R.id.prod_amount);
            description = itemView.findViewById(R.id.prod_description);

        }
    }
}
