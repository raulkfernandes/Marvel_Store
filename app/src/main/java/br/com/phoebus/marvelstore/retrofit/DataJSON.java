package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataJSON {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataJSON{" +
                ", data=" + data +
                '}';
    }
}
