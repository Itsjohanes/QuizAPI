package com.example.lks.datauser.Model;

import com.google.gson.annotations.SerializedName;

public class Notes {

    @SerializedName("id_user")
    private String id_user;
    @SerializedName("tipe_user")
    private String tipe_user;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("username")
    private String username;
    @SerializedName("telepon")
    private String telepon;
    @SerializedName("password")
    private String password;


    public Notes(){}

    public Notes(String id_user, String tipe_user, String nama, String alamat, String username, String telepon, String password) {
        this.id_user = id_user;
        this.tipe_user = tipe_user;
        this.nama = nama;
        this.alamat = alamat;
        this.username = username;
        this.telepon  = telepon;
        this.password = password;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getTipe_user() {
        return tipe_user;
    }

    public void setTipe_user(String tipe_user) {
        this.tipe_user = tipe_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
