package com.example.lks.soal;

import com.google.gson.annotations.SerializedName;

public class Soal {
    @SerializedName("id_soal")
    private String id_soal;
    @SerializedName("soal")
    private String soal;
    @SerializedName("opsi_a")
    private String opsi_a;
    @SerializedName("opsi_b")
    private String opsi_b;
    @SerializedName("opsi_c")
    private String opsi_c;
    @SerializedName("opsi_d")
    private String opsi_d;
    @SerializedName("opsi_e")
    private String opsi_e;
    @SerializedName("kunci")
    private String kunci;

    public Soal(String id_soal, String soal, String opsi_a, String opsi_b, String opsi_c, String opsi_d, String opsi_e, String kunci) {
        this.id_soal = id_soal;
        this.soal = soal;
        this.opsi_a = opsi_a;
        this.opsi_b = opsi_b;
        this.opsi_c = opsi_c;
        this.opsi_d = opsi_d;
        this.opsi_e = opsi_e;
        this.kunci = kunci;
    }
    public Soal(){

    }

    public String getId_soal() {
        return id_soal;
    }

    public void setId_soal(String id_soal) {
        this.id_soal = id_soal;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getOpsi_a() {
        return opsi_a;
    }

    public void setOpsi_a(String opsi_a) {
        this.opsi_a = opsi_a;
    }

    public String getOpsi_b() {
        return opsi_b;
    }

    public void setOpsi_b(String opsi_b) {
        this.opsi_b = opsi_b;
    }

    public String getOpsi_c() {
        return opsi_c;
    }

    public void setOpsi_c(String opsi_c) {
        this.opsi_c = opsi_c;
    }

    public String getOpsi_d() {
        return opsi_d;
    }

    public void setOpsi_d(String opsi_d) {
        this.opsi_d = opsi_d;
    }

    public String getOpsi_e() {
        return opsi_e;
    }

    public void setOpsi_e(String opsi_e) {
        this.opsi_e = opsi_e;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }
}
