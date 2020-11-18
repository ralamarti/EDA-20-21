package listas;

import nodos.Nodo;

public class ListaSimple {

	public Nodo primero;
	
	// Constructores
	
	/**
	 * Constructor de lista vacía
	 */
	public ListaSimple() {
		primero = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaSimple(Nodo primero) {
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
	 * X previous(x): Devuelve el nodo anterior al nodo con el elemento x 
	 * X first(): Devuelve el primer elemento de la lista 
	 * X last(): Devuelve el último elemento de la lista
	 * X clear(): Vacía la lista
	 * X size(): Devuelve el tamaño de la lista
	 * 
	 * Nota: eliminado método insertAtPosition(x, n) para evitar confusión y duplicidad innecesaria
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
	 * Método para comprobar el primer nodo de la lista
	 * @return El primer nodo de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public Nodo first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else return primero;		
	}
		
	/**
	 * Método que devuelve el último nodo de la lista
	 * @return El último nodo de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public Nodo last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			Nodo last  = primero;
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
			Nodo last = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}
	
	/**
	 * Método que inserta un nuevo nodo al principio de la lista	
	 * @param dato El elemento a insertar
	 */
	public void insertHead(Object dato) {
		Nodo nodo = new Nodo(dato, primero);
		primero = nodo;
	}
	
	/**
	 * Método que inserta un nuevo nodo al final de la lista
	 * @param dato El dato a insertar
	 */
	public void insertLast(Object dato) {
		if(isEmpty()) insertHead(dato); 
		else {
			Nodo last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			last.siguiente = new Nodo(dato);
		}
	}	
	
	/**
	 * Método que inserta un nuevo nodo tras una posición concreta
	 * Nota: se considera 0 como el índice de inicio, en otras palabras, la posición (6) hará referencia al 7º elemento de la lista:
	 * 		 (0) --> (1) --> (2) --> (3) --> (4) --> (5) --> {(6)}
	 * @param dato El dato a insertar
	 * @param position La posición tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepción si la lista está vacía o si la posición solicitada está fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else if (position < 0 || position >= size()) throw new Exception("Error: índice solicitado fuera de rango válido");
		else {
		
			// Creamos las variables auxiliares
			Nodo actual = primero;
	
			// Iteramos hasta llegar a la posición deseada (lista empieza en index 0)
			for (int i = 0; i < position; i++) actual = actual.siguiente;
	
			// Creamos el nuevo nodo basado en el actual
			Nodo nuevo = new Nodo(dato, actual.siguiente);
	
			// Actualizamos el enlace
			actual.siguiente = nuevo;

		}
	}
	
	/**
	 * Método para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de estar la lista vacía o no encontrar el nodo, lanza excepción
	 */
	public Nodo find(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			Nodo actual = primero;
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else actual = actual.siguiente;
			}
			return actual;
		}
		
	}
	
	/**
	 * Método para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de estar la lista vacía o no encontrar el nodo a eliminar, lanza excepción
	 */
	public void remove(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else if(primero.dato == dato && primero.siguiente == null) clear();
		else if(primero.dato == dato) primero = primero.siguiente;
		else {
			Nodo anterior = previous(dato);
			Nodo eliminar = find(dato);
			anterior.siguiente = eliminar.siguiente;
		}
		System.gc();		
	}
	
	/**
	 * Método para buscar el nodo anterior a otro nodo con un dato concreto
	 * @param dato El dato cuyo anterior deseamos encontrar
	 * @return El nodo anterior al nodo que contiene el dato concreto
	 * @throws Exception En caso de estar la lista vacía, solicitar el anterior al primero, o no encontrar el nodo, lanza excepción
	 */
	public Nodo previous(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else if(primero.dato == dato) throw new Exception("Error: el primero no tiene anterior en una lista simple");
		else {
			Nodo anterior = primero;
			Nodo actual = primero;
			
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else {
					anterior = actual;
					actual = actual.siguiente;
				}
			}
			return anterior;
		}		
	}
	

	
}
