package tools;

public class ListaDoble {
	
	public NodoDoble primero;
	
	// Constructores
	
	/**
	 * Constructor de lista vacía
	 */
	public ListaDoble() {
		primero = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaDoble(NodoDoble primero) {
		this.primero = primero;
	}
	
	/*
	 * Operaciones del TAD
	 * isEmpty(): Determina si la lista es vacía
	 * insertHead(x): Inserta el elemento x al principio de la lista, será el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, será el último elemento.
	 * insertAtPosition(n,x): Inserta el elemento x en la posición n
	 * insertAfter(n,x): Inserta el elemento x en la posición n+1
	 * find(x): Devuelve la posición del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el último elemento de la lista
	 * clear(): Vacía la lista
	 * size(): Devuelve el tamaño de la lista
	 * */

}
