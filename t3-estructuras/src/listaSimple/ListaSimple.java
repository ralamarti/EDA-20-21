package listaSimple;

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
	 * Operaciones del TAD Lista
	 * isEmpty(): Determina si la lista está vacía
	 * insertHead(x): Inserta el elemento x al principio de la lista, será el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, será el último elemento.
	 * insertAfter(x, n): Inserta el elemento x después de la posición n
	 * find(x): Devuelve el nodo con el elemento x
	 * remove(x): Elimina el nodo con el elemento x
	 * previous(x): Devuelve el nodo anterior al nodo con el elemento x 
	 * first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el último elemento de la lista
	 * clear(): Vacía la lista
	 * size(): Devuelve el tamaño de la lista
	 * 
	 * Nota: eliminado método insertAtPosition(x, n) para evitar confusión y duplicidad innecesaria
	 * */
	
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
	 */
	public Nodo first() {
		return primero;		
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
		last().siguiente = new Nodo(dato);
	}	
	
	/**
	 * Método que inserta un nuevo nodo tras una posición concreta
	 * @param dato El dato a insertar
	 * @param position La posición tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepción si la posición solicitada está fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {

		if (position < 0 || position >= size()) throw new Exception("Error: índice solicitado fuera de rango válido");
		else if (position == 0)	insertHead(dato);
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
	 * Método que devuelve el número de elementos en la lista
	 * @return El número de elementos en la lista
	 */
	public int size() {
		
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			Nodo last  = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}


	/**
	 * Método que devuelve el último nodo de la lista
	 * @return El último nodo de la lista
	 */
	public Nodo last() {
		
		// Entro a través del primero
		Nodo last  = primero;
		
		// Busco el último (nodo que apunta a null)
		while(last.siguiente != null) last = last.siguiente;
		
		// Devuelvo el último
		return last;
		
	}
	
	/**
	 * Método para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de no encontrar el nodo, lanza excepción
	 */
	public Nodo find(Object dato) throws Exception {
		
		Nodo actual = primero;
		while(actual.dato != dato) {
			if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
			else actual = actual.siguiente;
		}
		return actual;
		
	}
	
	/**
	 * Método para buscar el nodo anterior a otro nodo con un dato concreto
	 * @param dato El dato cuyo anterior deseamos encontrar
	 * @return El nodo anterior al nodo que contiene el dato concreto
	 * @throws Exception En caso de no encontrar el nodo, lanza excepción
	 */
	public Nodo previous(Object dato) throws Exception {
		
		if(primero.dato == dato) throw new Exception("Error: el primero no tiene anterior");
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
	
	/**
	 * Método para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de no encontrar el nodo, lanza excepción
	 */
	public void remove(Object dato) throws Exception {
		
		if(primero.dato == dato) {
			primero = primero.siguiente;
		} else {
			Nodo anterior = previous(dato);
			anterior.siguiente = anterior.siguiente.siguiente;
		}

		System.gc();		
	}
	
}
