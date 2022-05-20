package com.example.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ItemViewModel extends AndroidViewModel {

    Executor executor;

    ItemFinder itemFinder;

    MutableLiveData<ArrayList<GameItem>> gameItems = new MutableLiveData<>();

    public ItemViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        itemFinder = new ItemFinder();
    }

    public void buscar(String name) {

        final ItemFinder.Solicitud solicitud = new ItemFinder.Solicitud(name);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemFinder.buscar(solicitud, new ItemFinder.Callback() {
                    @Override
                    public void cuandoEsteBuscado(ArrayList<GameItem> itemResult) {
                        gameItems.postValue(itemResult);
                    }
                });
            }
        });
    }
}
