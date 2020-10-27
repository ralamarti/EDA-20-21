package nodos;

public class NodoDoble {
	
	public NodoDoble anterior;
	public Object dato;
	public NodoDoble siguiente;
	
	/**
	 * Constructor de nodo doble sin enlaces (null / dato / null)
	 * @param dato
	 */
	public NodoDoble(Object dato) {
		this.anterior = null;
		this.dato = dato;
		this.siguiente = null;
	}

	/**
	 * Constructor de nodo doble con enlaces (anterior / dato / siguiente)
	 * @param anterior
	 * @param dato
	 * @param siguiente
	 */
	public NodoDoble(NodoDoble anterior, Object dato, NodoDoble siguiente) {
		this.anterior = anterior;
		this.dato = dato;
		this.siguiente = siguiente;
	}
	
	
	
	
	
}
