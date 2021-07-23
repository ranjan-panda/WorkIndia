package com.workindia.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.workindia.R;
import com.workindia.ui.home.ItemDetail;

import java.util.List;

public class CustomAdapter2  extends RecyclerView.Adapter<com.workindia.ui.dashboard.CustomAdapter2.ViewHolder> {
    Context context;
    List<ItemDetail> items;
    public CustomAdapter2(Context context, List<ItemDetail> cases){
        this.context=  context;

        this.items=cases;

    }
    @NonNull
    @Override
    public com.workindia.ui.dashboard.CustomAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listtile2,parent,false);
        return new com.workindia.ui.dashboard.CustomAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.workindia.ui.dashboard.CustomAdapter2.ViewHolder holder, int position) {
        final ItemDetail item=items.get(position);

        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());



    }

    @Override
    public int getItemCount() {


        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView name,price;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);


        }
    }

}
