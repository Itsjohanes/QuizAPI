package com.example.lks.nilaikuis;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetNotess {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Notess> listDataNotes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Notess> getListDataNotes() {
        return listDataNotes;
    }

    public void setListDataNotes(List<Notess> listDataNotes) {
        this.listDataNotes = listDataNotes;
    }
}
