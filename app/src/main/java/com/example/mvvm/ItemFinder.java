package com.example.mvvm;

import java.util.ArrayList;

public class ItemFinder {

    public static class Solicitud {
        public String name;
        ArrayList<GameItem> gameItemsList = new ArrayList<GameItem>();

        public Solicitud(String name) {
            this.name = name;
            this.gameItemsList.add(new GameItem("name","name"));
            this.gameItemsList.add(new GameItem("k","asdf"));
            this.gameItemsList.add(new GameItem("sdg","sdgj"));
            this.gameItemsList.add(new GameItem("aslkdh", "sdfl"));

        }
    }

    interface Callback {
        void cuandoEsteBuscado(ArrayList<GameItem> itemResult);
    }

    public void buscar(Solicitud solicitud, Callback callback) {
        ArrayList<GameItem> search = new ArrayList<GameItem>();

        try {
            for (GameItem gi : solicitud.gameItemsList) {
                if(gi.getName().contains(solicitud.name)){
                    search.add(gi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        callback.cuandoEsteBuscado(search);
    }
}