package listaTools;

public class NodoLista {

	Object dato;
	NodoLista siguienteNodo;
	
	/*
	 * Constructores de nodos para una lista simplemente enlazada
	 * */
	public NodoLista (Object dato) {
		
		// Equivalentemente, this(dato, null) llama al constructor de abajo con esos parámetros
		this.dato = dato;
		this.siguienteNodo = null; 
		// Por defecto siguienteNodo ya sería null pero lo ponemos explícitamente por claridad
				
	}

	public NodoLista (Object dato, NodoLista siguienteNodo) {
		this.dato = dato; 
		this.siguienteNodo = siguienteNodo;
	}

	
	/*
	 * Bonus
	 * printNode(): imprime un nodo por pantalla
	 */
	
	@Override
	public String toString() {
		return "NodoLista [dato=" + dato + "]";
	}
	

	
	
}
