package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("role")
    @Expose
    private String role;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
