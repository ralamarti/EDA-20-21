package pilas;

public class PilaArray {

	public int size;
	public int[] datos;
	public int cima;
	
	/*
	 * X PilaArray(): Inicializa una pila vacía
	 * X push(x): Inserta un elemento en la pila
	 * pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobación si la pila está vacía
	 * X isFull(): Comprobación si la pila está llena
	 * clear(): Vacía la pila
	 * X peek(): Valor cima de la pila (sin extracción)
	 * X size(): Número de elementos en la pila
	 * X capacity(): Tamaño máximo de la pila
	 */
	
	public PilaArray(int size) {
		this.size = size;
		this.datos = new int[size];
		this.cima = -1;
	}
	
	public boolean isEmpty() {
		return cima == -1;
	}
	
	public boolean isFull() {
		return cima == this.size-1;
	}
	
	public int capacity() {
		return this.size;
	}
	public int size() {
		return this.cima+1;
	}
	public int peek() {
		return this.datos[cima];
	}
	
	public void push(int nuevoDato) {
		
		if(!this.isFull()) {
			this.datos[cima+1] = nuevoDato;
			cima++;
		} else {
			System.out.println("Stack overflow");
		}
		
	}
	
	public int pop() {
		int valor = peek();
		cima--;
		return valor;
	}
	
	public void clear() {
		cima = -1;
	}
	
}
