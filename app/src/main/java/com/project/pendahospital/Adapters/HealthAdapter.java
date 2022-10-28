package com.project.pendahospital.Adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.HealthModel;
import com.project.pendahospital.Patient.DoctorsActivity;
import com.project.pendahospital.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {

    public HealthAdapter(Context context, ArrayList<HealthModel> list, DoctorsActivity doctorsActivity) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<HealthModel>list;
    @NonNull
    @Override
    public HealthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.health_isssues,parent,false));

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.amount.setText(list.get(position).getAmount());
        holder.cardView.setBackgroundColor(holder.itemView.getResources().getColor(getRandomColor(),null));

    }

    private int getRandomColor() {
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        Random random= new Random();
        int number = random.nextInt(colorCode.size());
        return colorCode.get(number);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, amount;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_txt);
            name = itemView.findViewById(R.id.name_text);
            amount = itemView.findViewById(R.id.textView18);
            cardView= itemView.findViewById(R.id.cardView1);
        }
    }
}
