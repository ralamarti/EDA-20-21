package listaTools;

public class NodoLista {

	Object dato;
	NodoLista siguienteNodo;
	
	/*
	 * Constructores de nodos para una lista simplemente enlazada
	 * */
	NodoLista (Object dato) {
		
		// Equivalentemente, this(dato, null) llama al constructor de abajo con esos parámetros
		this.dato = dato;
		this.siguienteNodo = null; 
		// Por defecto siguienteNodo ya sería null pero lo ponemos explícitamente por claridad
		
	}

	NodoLista (Object dato, NodoLista siguienteNodo) {
		this.dato = dato; 
		this.siguienteNodo = siguienteNodo;
	}	
}
