package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_ord;
	private String data_ord;
	private String ora_ord;
	private String ordine;
	private double totale;
	private String user;
	
	public int getId_ord() {
		return id_ord;
	}
	public void setId_ord(int id_ord) {
		this.id_ord = id_ord;
	}
	public String getData_ord() {
		return data_ord;
	}
	public void setData_ord(String data_ord) {
		this.data_ord = data_ord;
	}
	public String getOra_ord() {
		return ora_ord;
	}
	public void setOra_ord(String ora_ord) {
		this.ora_ord = ora_ord;
	}
	
	public String getOrdine() {
		return ordine;
	}
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
