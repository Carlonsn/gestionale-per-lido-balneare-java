package model;

import java.io.Serializable;

public class Utente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String ruolo;
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		
		this.cognome = cognome;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
