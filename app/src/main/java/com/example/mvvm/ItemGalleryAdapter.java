package com.example.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class ItemGalleryAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<GameItem> list = Collections.emptyList();

    Context context;
    public ItemGalleryAdapter(List<GameItem> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.item_card, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder viewHolder, final int position) {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.name.setText(list.get(position).name);
        viewHolder.description.setText(list.get(position).description);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {}
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
