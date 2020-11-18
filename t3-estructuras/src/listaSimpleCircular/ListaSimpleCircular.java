package listaSimpleCircular;

import nodos.Nodo;

public class ListaSimpleCircular {

	public Nodo acceso;
	
	/**
	 * Constructor de lista vacía
	 */
	public ListaSimpleCircular() {
		acceso = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaSimpleCircular(Nodo acceso) {
		this.acceso = acceso;
		this.acceso.siguiente = acceso;
	}
	
	/*
	 * Operaciones del TAD
	 * X isEmpty(): Determina si la lista está vacía
	 * X insert(x): Inserta el elemento x entre el nodo anterior al nodo de acceso y el nodo de acceso actual, será el nuevo nodo de acceso
	 * X insertAfter(x, y): Inserta el elemento x después del nodo con dato y, será el nuevo nodo de acceso
	 * X find(x): Devuelve el nodo con el elemento x
	 * X remove(x): Elimina el nodo con elemento x
	 * X previous(x): Devuelve el nodo anterior al nodo con elemento x 
	 * X clear(): Vacía la lista
	 * X size(): Devuelve el tamaño de la lista
	 * 
	 * Nota: conservamos first() y last() para acceder de forma sencilla a los nodos de acceso y su anterior
 	 *       pero hay que tener en cuenta que ambos van a estar cambiando constantemente
	 * 
	 * Nota: insertHead(x), insertLast(x) no tienen sentido en una lista circular, sustituidos por insert(x);
	 * Nota: modificado insertAfter(x, n) con posición -> insertAfter(x, y) con dato; no tiene sentido controlar posición en una lista circular
	 * Nota: eliminado método insertAtPosition(x, n) para evitar confusión y duplicidad innecesaria
	 * 
	 **/
	
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
	 * Método para comprobar el primer nodo de la lista
	 * @return El primer nodo de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public Nodo first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else return acceso;		
	}
		
	/**
	 * Método que devuelve el último nodo de la lista
	 * @return El último nodo de la lista
	 * @throws Exception Lanza una excepción si la lista está vacía
	 */
	public Nodo last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			Nodo last  = acceso;
			while(last.siguiente != acceso) last = last.siguiente;
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
			Nodo last = acceso;
			while(last.siguiente != acceso){
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
	public void insert(Object dato) {
		if(isEmpty()) {
			acceso = new Nodo(dato);
			acceso.siguiente = acceso;
		} else {
			Nodo last  = acceso;
			while(last.siguiente != acceso) last = last.siguiente;
			Nodo nuevo = new Nodo(dato, acceso);
			last.siguiente = nuevo;
			acceso = nuevo;
		}
	}
	
	/**
	 * Método que inserta un nuevo nodo tras otro nodo con un dato concreto
	 * @param dato El dato a insertar
	 * @param referencia El dato de referencia tras el cual se desea insertar un nuevo nodo
	 * @throws Exception Lanza una excepción si la lista está vacía o si no se encuentra el dato de referencia
	 */
	public void insertAfter(Object dato, Object referencia) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
		
			Nodo nodoReferencia = find(referencia);
	
			// Creamos el nuevo nodo basado en el actual
			Nodo nuevo = new Nodo(dato, nodoReferencia.siguiente);
	
			// Actualizamos el enlace
			nodoReferencia.siguiente = nuevo;

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
			Nodo actual = acceso;
			while(actual.dato != dato) {
				if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
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
		else if(acceso.dato == dato && acceso.siguiente == acceso) clear();
		else if(acceso.dato == dato) {
			last().siguiente = acceso.siguiente;
			acceso = acceso.siguiente;
		}
		else {
			Nodo anterior = previous(dato);
			anterior.siguiente = anterior.siguiente.siguiente;
		}
		System.gc();		
	}
	
	/**
	 * Método para buscar el nodo anterior a otro nodo con un dato concreto
	 * @param dato El dato cuyo anterior deseamos encontrar
	 * @return El nodo anterior al nodo que contiene el dato concreto
	 * @throws Exception En caso de estar la lista vacía o no encontrar el nodo, lanza excepción
	 */
	public Nodo previous(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vacía");
		else {
			Nodo anterior = acceso;
			Nodo actual = acceso;
			
			while(actual.dato != dato) {
				if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
				else {
					anterior = actual;
					actual = actual.siguiente;
				}
			}
			return anterior;
		}		
	}
	

	
}
