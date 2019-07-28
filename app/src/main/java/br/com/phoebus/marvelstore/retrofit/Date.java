package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("date")
    @Expose
    private String date;

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Date{" +
                "date='" + date + '\'' +
                '}';
    }
}
