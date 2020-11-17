package nodos;

public class Nodo {

	public Object dato;
	public Nodo siguiente;
	
	//Constructores 
	public Nodo (Object dato) {		
		this.dato = dato;
		this.siguiente = null;
	}
	
	public Nodo (Object dato, Nodo siguiente) {
		this.dato=dato; 
		this.siguiente=siguiente;
	}
	
}
