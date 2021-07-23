package com.workindia.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.workindia.R;

import java.util.List;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    List<ItemDetail> items;
    public CustomAdapter(Context context, List<ItemDetail> cases){
        this.context=  context;

        this.items=cases;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listtile,parent,false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        final ItemDetail item=items.get(position);

        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        if(item.getExtra()!="null")
        holder.extra.setText(item.getExtra());


    }

    @Override
    public int getItemCount() {


        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView name,price,extra;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            extra=itemView.findViewById(R.id.extra);

        }
    }

}
