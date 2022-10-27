package com.project.pendahospital.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.ProductsModel;
import com.project.pendahospital.Patient.PhamarcyActivity;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public ProductsAdapter(Context context, ArrayList<ProductsModel> list, PhamarcyActivity phamarcyActivity) {
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
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.title.setText(list.get(position).getName());
        holder.amount.setText(list.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount,title;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView7);
            title= itemView.findViewById(R.id.textView15);
            amount = itemView.findViewById(R.id.textView16);
        }
    }
}
