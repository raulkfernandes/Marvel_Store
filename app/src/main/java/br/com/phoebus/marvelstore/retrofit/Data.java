package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("results")
    @Expose
    private ArrayList<ComicJSON> results;

    public ArrayList<ComicJSON> getComicsJSON() {
        return results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "results=" + results +
                '}';
    }
}
