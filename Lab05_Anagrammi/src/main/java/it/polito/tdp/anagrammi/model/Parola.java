package it.polito.tdp.anagrammi.model;

public class Parola {

	int id;
	String nome;
	boolean corretta;
	
	public Parola(String nome, boolean corretta) {
		//this.id = id;
		this.nome = nome;
		this.corretta=corretta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getCorretta() {
		return corretta;
	}
	
	public void serCorretta(boolean corretta) {
		this.corretta=corretta;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}