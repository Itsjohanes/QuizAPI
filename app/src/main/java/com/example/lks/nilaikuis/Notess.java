package com.example.lks.nilaikuis;

import com.google.gson.annotations.SerializedName;

public class Notess {

    @SerializedName("id_kuis")
    private String id_kuis;
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("nilai")
    private String nilai;
    @SerializedName("benar")
    private String benar;
    @SerializedName("salah")
    private String salah;
    @SerializedName("kosong")
    private String kosong;
    @SerializedName("jawaban")
    private String jawaban;


    public Notess() {
    }

    public Notess(String id_kuis, String id_user, String nilai, String benar, String salah, String kosong, String jawaban) {
        this.id_kuis = id_kuis;
        this.id_user = id_user;
        this.nilai = nilai;
        this.benar = benar;
        this.salah = salah;
        this.kosong = kosong;
        this.jawaban = jawaban;
    }

    public String getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(String id_kuis) {
        this.id_kuis = id_kuis;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getBenar() {
        return benar;
    }

    public void setBenar(String benar) {
        this.benar = benar;
    }

    public String getSalah() {
        return salah;
    }

    public void setSalah(String salah) {
        this.salah = salah;
    }

    public String getKosong() {
        return kosong;
    }

    public void setKosong(String kosong) {
        this.kosong = kosong;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
