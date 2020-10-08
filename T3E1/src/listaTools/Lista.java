package listaTools;
public class Lista {

	public NodoLista primero;

	public Lista() {
		// TODO
	}



	/*
	 * Operaciones del TAD
	 * isEmpty(): Determina si la lista es vacía
	 * insertHead(x): Inserta el elemento x al principio de la lista, será el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, será el último elemento.
	 * insertAtPosition(n,x): Inserta el  elemento x después del elemento en la posición n
	 * find(x): Devuelve la posición del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el último elemento de la lista
	 * clear(): Vacía la lista
	 * */
	
	public Lista insertHead(Object o) {
		
		// Crea un nuevo nodo
		NodoLista nuevoNodo = new NodoLista(o);

		// Enlaza el nuevo nodo al frente de la lista
		nuevoNodo.siguienteNodo = primero;
		primero = nuevoNodo;

		// Devuelve esta lista
		return this;

	}
		
	/*
	 * Bonus
	 * printList(): imprime la lista por pantalla
	 * size(): devuelve el tamaño de la lista
	 */

	
	
}
