package com.example.lks.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("id_user")
	private String userId;
	@SerializedName("nama")
	private String name;
	@SerializedName("username")
	private String username;
	@SerializedName("telepon")
	private String telepon;
	@SerializedName("alamat")
	private String alamat;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}