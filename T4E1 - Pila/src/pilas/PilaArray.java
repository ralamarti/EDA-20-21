package pilas;

public class PilaArray {
	
	public int cima;
	public int size;
	public int[] datos;
	
	/*
	 * X PilaArray(): Inicializa una pila vacía
	 * x push(x): Inserta un elemento en la pila
	 * pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobación si la pila está vacía
	 * X isFull(): Comprobación si la pila está llena
	 * X clear(): Vacía la pila
	 * X peek(): Valor cima de la pila (sin extracción)
	 * X size(): Número de elementos en la pila
	 * X capacity(): Tamaño máximo de la pila
	 */
	
	public PilaArray(int size) {
		this.size = size;
		this.cima = -1;
		this.datos = new int[size];
	}
	
	// isEmpty(): Comprobación si la pila está vacía
	
	public boolean isEmpty() {
		return this.cima==-1;
	}
	
	// isFull(): Comprobación si la pila está llena
	
	public boolean isFull() {
		return this.cima==this.size-1;
	}
	
	// size(): Número de elementos en la pila
	
	public int size() {
		return this.cima+1;
	}
	
	// capacity(): Tamaño máximo de la pila
	
	public int capacity() {
		return this.size;
	}
	
	// clear(): Vacía la pila
	
	public void clear() {
		
		this.cima = -1;
	}
	
	// peek(): Valor cima de la pila (sin extracción)
	
	public void peek()
	{
		if (!isEmpty()) {
			System.out.println("Data is " + this.datos[this.cima]);
		} else System.out.println("Cannot return value (stack is empty)");
	}
	
	// push(x): Inserta un elemento en la pila
	public void push(int dato) {
		if(!isFull()) {
			this.cima++;
			this.datos[this.cima]=dato;
		}else System.out.println("esta llena la pila");
	}
	
	//pop(): Extrae un elemento de la pila
	public void pop() {
		if(!isEmpty()) {
			System.out.println("Data is " + this.datos[this.cima]);
			this.cima--;
		}else System.out.println("esta vacia la pila");
	}
	
	
	
}
