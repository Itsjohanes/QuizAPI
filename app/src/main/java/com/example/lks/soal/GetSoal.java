package com.example.lks.soal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSoal {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Soal> listSoal;

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

    public List<Soal> getListSoal() {
        return listSoal;
    }
    public void setListSoal(List<Soal> listSoal) {
        this.listSoal = listSoal;
    }
}
