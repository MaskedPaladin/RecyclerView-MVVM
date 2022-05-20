package com.example.mvvm;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    View view;
    ItemViewHolder(View itemView)
    {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.card_name);
        description = (TextView)itemView.findViewById(R.id.card_description);
        view  = itemView;
    }
}