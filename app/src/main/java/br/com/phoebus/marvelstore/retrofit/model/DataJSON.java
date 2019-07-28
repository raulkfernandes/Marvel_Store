package br.com.phoebus.marvelstore.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataJSON {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

//    public void setData(Data data) {
//        this.data = data;
//    }

    public String getStatus() {
        return status;
    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

    @Override
    public String toString() {
        return "DataJSON{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
