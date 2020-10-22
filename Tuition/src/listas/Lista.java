package listas;

public class Lista {
	
	// primero --> 2 --> 3 --> 4 --> ... --> ultimo --> null
	// [valor] (enlace) --> [valor] (enlace)
	
	public Nodo primero;
	
	// Constructor lista vacía (sin elementos)
	// null
	public Lista() {
		primero = null;		
	}
	
	// Constructor de lista con elemento
	public Lista(Nodo nodo) {
		primero = nodo;
	}
	
	/*
	 * Operaciones de la lista
	 * X isEmpty(): Determina si la lista es vacía
	 * X insertHead(x): Inserta el elemento x al principio de la lista, será el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, será el último elemento.
	 * insertAtPosition(n,x): Inserta el elemento x en la posición n
	 * insertAfter(n,x): Inserta el elemento x en la posición n+1
	 * find(x): Devuelve la posición del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * X first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el último elemento de la lista
	 * X clear(): Vacía la lista
	 * */
	
	public Nodo first() {
		return primero;
	}
	
	public void clear() {
		primero = null;
	}
	
	public boolean isEmpty() {
		if(primero != null) return false;
		else return true;
	}
	
	public void insertHead(Nodo nuevo) {
		// 23(primero) --> null
		// 154(nuevo)/(primero) --> 23 (nuevo.enlace) --> null
		nuevo.enlace = primero;
		primero = nuevo;
	}

}
