package tools;

public class NodoLista {

	Object dato;
	NodoLista enlace;
	
	//Constructores 
	public NodoLista (Object x) {		
		this.dato = x;
		this.enlace = null;
	}
	
	public NodoLista (Object x, NodoLista sig) {
		dato=x; 
		enlace=sig;
	}


	
	/*
	 * Bonus
	 * printNode(): imprime un nodo por pantalla
	 */
	
	@Override
	public String toString() {
		return "NodoLista [dato=" + dato + ", enlace=" + enlace + "]";
	}
	
	
}
