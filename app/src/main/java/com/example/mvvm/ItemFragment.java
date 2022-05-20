package com.example.mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.FragmentItemBinding;

import java.util.ArrayList;

public class ItemFragment extends Fragment {
    private FragmentItemBinding binding;
    private ArrayList<GameItem> toViewItems = new ArrayList<GameItem>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentItemBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ItemViewModel itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        binding.buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.name.getText().toString();
                itemViewModel.buscar(name);
            }
        });

        itemViewModel.gameItems.observe(getViewLifecycleOwner(), new Observer<ArrayList<GameItem>>() {
            @Override
            public void onChanged(ArrayList<GameItem> gameItems) {
                toViewItems = new ArrayList<GameItem>();
                toViewItems.addAll(gameItems);
                RecyclerView recyclerView = (RecyclerView) binding.recyclerItems;
                ItemGalleryAdapter adapter = new ItemGalleryAdapter(toViewItems, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
            }
        });
    }
}