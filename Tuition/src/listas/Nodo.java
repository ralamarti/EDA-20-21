package listas;

public class Nodo {

	public int valor;
	public Nodo enlace;
	
	// Constructor usa valor
	public Nodo(int valor) {
		this.valor = valor;
		this.enlace = null;
	}	
	
	// Constructor usa valor y enlace
	public Nodo(int valor, Nodo enlace) {
		this.valor = valor;
		this.enlace = enlace;
	}	
	
}
