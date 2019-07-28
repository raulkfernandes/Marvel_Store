package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("price")
    @Expose
    private double price;

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }
}
