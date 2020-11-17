package listaDobleCircular;

import nodos.NodoDoble;

public class ListaDobleCircular {

	public NodoDoble acceso;
	
	// Constructores
	
	/**
	 * Constructor de lista vacía
	 */
	public ListaDobleCircular() {
		acceso = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaDobleCircular(NodoDoble acceso) {
		this.acceso = acceso;
		this.acceso.siguiente = acceso;
		this.acceso.anterior = acceso;
	}
	
	/*
	 * Operaciones del TAD Lista
	 * isEmpty(): Determina si la lista está vacía
	 * insert(x): Inserta el elemento x entre el nodo anterior al nodo de acceso y el nodo de acceso actual, será el nuevo nodo de acceso
	 * insertAfter(x, y): Inserta el elemento x después del nodo con dato y, será el nuevo nodo de acceso
	 * find(x): Devuelve el nodo con el elemento x
	 * remove(x): Elimina el nodo con elemento x
	 * previous(x): Devuelve el nodo anterior al nodo con elemento x 
	 * clear(): Vacía la lista
	 * size(): Devuelve el tamaño de la lista
	 * 
	 * Nota: eliminados first() y last(), no tienen sentido en una lista circular y podemos acceder directamente
	 * 		 a través de las variables acceso y acceso.anterior
	 * 
	 * Nota: eliminado previous(), podemos acceder directamente a .anterior
	 * 
	 * Nota: insertHead(x), insertLast(x) no tienen sentido en una lista circular, sustituidos por insert(x);
	 * Nota: modificado insertAfter(x, n) con posición -> insertAfter(x, y) con dato; no tiene sentido controlar posición en una lista circular
	 * Nota: eliminado método insertAtPosition(x, n) para evitar confusión y duplicidad innecesaria
	 * */
	
	/**
	 * Método que comprueba si la lista está vacía
	 * @return true si la lista está vacía, false si la lista tiene elementos
	 */
	public boolean isEmpty() {
		return acceso == null;		
	}
	
	/**
	 * Método que limpia la lista
	 */
	public void clear() {
		acceso = null;
		System.gc(); // Invoca al garbage collector de java, que limpia la memoria
	}

	/**
	 * Método que inserta un nuevo nodo justo antes del nodo de acceso
	 * El nodo introducido será el nuevo nodo de acceso
	 * @param dato El elemento a insertar
	 */
	public void insert(Object dato) {
		NodoDoble nodo = new NodoDoble(acceso.anterior, dato, acceso);
		acceso.anterior.siguiente = nodo;
		acceso.anterior = nodo;
		acceso = nodo;
	}
	
	/**
	 * Método que inserta un nuevo nodo tras otro nodo con un dato concreto
	 * @param datoInsertar El dato a insertar
	 * @param datoReferencia El dato tras el cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepción si no se encuentra el nodo de referencia
	 */
	public void insertAfter(Object datoInsertar, Object datoReferencia) throws Exception {

		NodoDoble nodoReferencia = find(datoReferencia);
		NodoDoble nodoInsertar = new NodoDoble(nodoReferencia, datoInsertar, nodoReferencia.siguiente);
		nodoReferencia.siguiente.anterior = nodoInsertar;
		nodoReferencia.siguiente = nodoInsertar;
		
	}
	
	/**
	 * Método que devuelve el número de elementos en la lista
	 * @return El número de elementos en la lista
	 */
	public int size() {
		
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			NodoDoble last = acceso;
			while(last.siguiente != acceso){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}


	/**
	 * Método para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de no encontrar el nodo, lanza excepción
	 */
	public NodoDoble find(Object dato) throws Exception {
		
		NodoDoble actual = acceso;
		while(actual.dato != dato) {
			if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
			else actual = actual.siguiente;
		}
		return actual;
		
	}
	
	/**
	 * Método para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de no encontrar el nodo, lanza excepción
	 */
	public void remove(Object dato) throws Exception {
		
		if(acceso.dato == dato && acceso.siguiente == acceso) clear();
		else if(acceso.dato == dato) {
			acceso.anterior.siguiente = acceso.siguiente;
			acceso.siguiente.anterior = acceso.anterior;
			acceso = acceso.siguiente;
		} else {
			NodoDoble nodoEliminar = find(dato);
			nodoEliminar.anterior.siguiente = nodoEliminar.siguiente;
			nodoEliminar.siguiente.anterior = nodoEliminar.anterior;
		}

		System.gc();		
	}
	
}
