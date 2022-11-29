package com.project.pendahospital.Adapters;

import static com.project.pendahospital.Adapters.DBmain.TABLENAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.CartModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    ArrayList<CartModel> list;
    SQLiteDatabase sqLiteDatabase;
    int cart_item;

    public CartAdapter(Context context, ArrayList<CartModel> list, SQLiteDatabase sqLiteDatabase, int cart_item) {
        this.context = context;
        this.list = list;
        this.sqLiteDatabase = sqLiteDatabase;
        this.cart_item = cart_item;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final  CartModel cartModel = list.get(position);
        holder.prod.setText(list.get(position).getAmount());
        holder.amount.setText(list.get(position).getProduct());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBmain dBmain= new DBmain(context);
                sqLiteDatabase= dBmain.getReadableDatabase();
                long recdelete = sqLiteDatabase.delete(TABLENAME, "id="+cartModel.getId(),null);
                if (recdelete!= -1){
                    Toast.makeText(context,"item successfully deleted",Toast.LENGTH_SHORT).show();
                    list.remove(position);
                    notifyDataSetChanged();

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView prod,amount;
        ImageButton delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_cart);
            prod = itemView.findViewById(R.id.cart_prod);
            amount = itemView.findViewById(R.id.amount1);
            delete = itemView.findViewById(R.id.delete_btn);

        }
    }
}
