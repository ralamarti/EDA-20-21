package tools;

public class NodoDoble {

	Object dato;
	NodoDoble anterior;
	NodoDoble siguiente;
	
	public NodoDoble (Object x) {		
		this.dato = x;
		this.anterior = null;
		this.siguiente = null;
	}

	public NodoDoble(Object dato, NodoDoble anterior, NodoDoble siguiente) {
		this.dato = dato;
		this.anterior = anterior;
		this.siguiente = siguiente;
	}
	
}
