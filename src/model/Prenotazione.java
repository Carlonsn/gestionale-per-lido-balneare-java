package model;

import java.io.Serializable;

public class Prenotazione implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_pren;
	private String data_pren;
	private String data;
	private int id_ombr;
	private double prezzo;
	private String user;

	
	public int getId_pren() {
		
		return id_pren;
	}
	
	public void setId_pren(int id_pren) {
		
		this.id_pren = id_pren;
	}
	
	public String getData_pren() {
		
		return data_pren;
	}
	
	public void setData_pren(String data_pren) {
		
		this.data_pren = data_pren;
		
	}
	
	public String getData() {
		
		return data;
	}
	public void setData(String data) {
		
		this.data = data;
	}
	
	public int getId_ombr() {
		
		return id_ombr;
	}
	
	public void setId_ombr(int id_ombr) {
		
		this.id_ombr = id_ombr;
	}
	
	public double getPrezzo() {
		
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		
		this.prezzo = prezzo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
