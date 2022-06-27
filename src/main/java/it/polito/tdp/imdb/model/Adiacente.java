package it.polito.tdp.imdb.model;

public class Adiacente {
	Director d;
	int peso;
	public Adiacente(Director d, int peso) {
		super();
		this.d = d;
		this.peso = peso;
	}
	public Director getD() {
		return d;
	}
	public void setD(Director d) {
		this.d = d;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return  d + " " + peso + "\n";
	}
	
	

}
