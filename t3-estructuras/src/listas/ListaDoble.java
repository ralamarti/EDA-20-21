package listas;

import nodos.NodoDoble;

public class ListaDoble {

	public NodoDoble primero;
	
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
	 * X isEmpty(): Determina si la lista está vacía
	 * X insertHead(x): Inserta el elemento x al principio de la lista, será el nuevo primer elemento.
	 * X insertLast(x): Inserta el elemento x al final de la lista, será el último elemento.
	 * X insertAfter(x, n): Inserta el elemento x después de la posición n
	 * X find(x): Devuelve el nodo con el elemento x
	 * X remove(x): Elimina el nodo con el elemento x
	 * X first(): Devuelve el primer nodo de la lista 
	 * X last(): Devuelve el último nodo de la lista
	 * X clear(): Vacía la lista
	 * X size(): Devuelve el tamaño de la lista
	 * 
	 * Nota: eliminado método insertAtPosition(x, n) para evitar confusión y duplicidad innecesaria
	 * Nota: eliminado método previous(x), ya que podemos acceder al anterior mediante .anterior
	 * 
	 **/
	
	/**
	 * Método que comprueba si la lista está vacía
	 * @return true si la lista está vacía, false si la lista tiene elementos
	 */
	public boolean isEmpty() {
		return primero == null;		
	}
	
	/**
	 * Método que limpia la lista
	 */
	public void clear() {
		primero = null;
		System.gc(); // Invoca al garbage collector de java, que limpia la memoria
	}
	
	/**
	 * Método para comprobar el primer NodoDoble de la lista
	 * @return El primer NodoDoble de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public NodoDoble first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else return primero;		
	}
		
	/**
	 * Método que devuelve el último NodoDoble de la lista
	 * @return El último NodoDoble de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public NodoDoble last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			NodoDoble last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			return last;
		}		
	}
	
	/**
	 * Método que devuelve el número de elementos en la lista
	 * @return El número de elementos en la lista
	 */
	public int size() {
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			NodoDoble last = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}
	
	/**
	 * Método que inserta un nuevo NodoDoble al principio de la lista	
	 * @param dato El elemento a insertar
	 */
	public void insertHead(Object dato) {
		NodoDoble NodoDoble = new NodoDoble(null, dato, primero);
		primero = NodoDoble;
	}
	
	/**
	 * Método que inserta un nuevo NodoDoble al final de la lista
	 * @param dato El dato a insertar
	 */
	public void insertLast(Object dato) {
		if(isEmpty()) insertHead(dato); 
		else {
			NodoDoble last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			last.siguiente = new NodoDoble(last, dato, null);
		}
	}	
	
	/**
	 * Método que inserta un nuevo NodoDoble tras una posición concreta
	 * Nota: se considera 0 como el índice de inicio, en otras palabras, la posición (6) hará referencia al 7º elemento de la lista:
	 * 		 (0) --> (1) --> (2) --> (3) --> (4) --> (5) --> {(6)}
	 * @param dato El dato a insertar
	 * @param position La posición tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepción si la lista está vacía o si la posición solicitada está fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else if (position < 0 || position >= size()) throw new Exception("Error: índice solicitado fuera de rango válido");
		else if (position == size()-1) insertLast(dato);
		else {
		
			// Creamos las variables auxiliares
			NodoDoble actual = primero;
	
			// Iteramos hasta llegar a la posición deseada (lista empieza en index 0)
			for (int i = 0; i < position; i++) actual = actual.siguiente;
	
			// Creamos el nuevo NodoDoble basado en el actual
			NodoDoble nuevo = new NodoDoble(actual, dato, actual.siguiente);
	
			// Actualizamos los enlaces
			actual.siguiente.anterior = nuevo;
			actual.siguiente = nuevo;

		}
	}
	
	/**
	 * Método para buscar un NodoDoble con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El NodoDoble que contiene el dato concreto, null si no se encuentra el NodoDoble
	 * @throws Exception En caso de estar la lista vacía o no encontrar el NodoDoble, lanza excepción
	 */
	public NodoDoble find(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			NodoDoble actual = primero;
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else actual = actual.siguiente;
			}
			return actual;
		}
		
	}
	
	/**
	 * Método para eliminar un NodoDoble con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de estar la lista vacía o no encontrar el NodoDoble a eliminar, lanza excepción
	 */
	public void remove(Object dato) throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else if(primero.dato == dato && primero.siguiente == null) clear();
		else if(primero.dato == dato) {
			primero = primero.siguiente;
			primero.anterior = null;
		}
		else {
			NodoDoble eliminar = find(dato);
			eliminar.anterior.siguiente = eliminar.siguiente;
			eliminar.siguiente.anterior = eliminar.anterior;
		}
		System.gc();		
	}
	
	
}
