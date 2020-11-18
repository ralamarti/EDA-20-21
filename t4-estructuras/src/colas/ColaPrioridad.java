package colas;

public class ColaPrioridad {
	
	public ColaEnlazada[] colas;
	
	public ColaPrioridad(int numPrioridades) {
		colas = new ColaEnlazada[numPrioridades];
		for(int i = 0; i < numPrioridades; i++) {
			colas[i] = new ColaEnlazada();
		}
	}
	
	/*
	 * X ColaPrioridad(): Inicializa una cola de prioridad vacía
	 * X push(x, i): Inserta un elemento x al final de la cola con prioridad i
	 * X pop(): Extrae un elemento del principio de la primera cola no vacía
	 * X isEmpty(): Comprobación colas vacías
	 * X clear(): Vacía todas las colas
	 * X size(): Número de elementos en todas las colas
	 */
	
	public boolean isEmpty() {
		
		for(ColaEnlazada cola : colas) {
			if(!cola.isEmpty()) return false;
		}
		
		return true;
		
	}
	
	public void clear() {
		for(ColaEnlazada cola : colas) {
			cola.clear();
		}
	}
	
	public int size() {
		int size = 0;
		for(ColaEnlazada cola : colas) {
			size += cola.size;
		}
		return size;
	}
	
	// Inserta un elemento x al final de la cola con prioridad i
	public void push(Object elemento, int prioridad) {
		colas[prioridad].push(elemento);
	}
	
	// Extrae un elemento del principio de la primera cola no vacía
	public Object pop() throws Exception {

		for(ColaEnlazada cola : colas){
			if(!cola.isEmpty()) return cola.pop();
		}

		// Podría ser que todas las colas estén vacías, en ese caso llegaremos a este código
		System.out.println("Error: todas las colas están vacías");
		return null;
	}

}