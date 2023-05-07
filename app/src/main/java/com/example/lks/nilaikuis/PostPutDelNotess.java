package com.example.lks.nilaikuis;

import com.google.gson.annotations.SerializedName;

public class PostPutDelNotess {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    Notess mNotes;
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
    public Notess getHeros() {
        return mNotes;
    }
    public void setHeros(Notess Notes) {
        mNotes = Notes;
    }
}
