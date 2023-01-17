package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CarrelloBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Prodotto> lista = new ArrayList<Prodotto>();
	private double totale = 0;
	
	public ArrayList<Prodotto> getLista() {
		
		return lista;
	}
	
	public void setLista(ArrayList<Prodotto> lista) {
		this.lista = lista;
	}

	public double getTotale() {

		return totale;
	}

	public void setTotale(double totale) {
	
			this.totale = totale;
		
	}

}
