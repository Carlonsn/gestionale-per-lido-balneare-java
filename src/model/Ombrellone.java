package model;

import java.io.Serializable;

public class Ombrellone implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int riga;
	private int posto;
	private double prezzo;
	private String data;
	private String user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRiga() {
		return riga;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getPosto() {
		return posto;
	}
	public void setPosto(int posto) {
		this.posto = posto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
