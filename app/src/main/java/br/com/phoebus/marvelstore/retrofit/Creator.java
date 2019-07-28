package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Creator {

    @SerializedName("items")
    @Expose
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "items=" + items +
                '}';
    }
}
