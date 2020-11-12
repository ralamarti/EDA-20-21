package pilaEnlazada;

import nodo.Nodo;

public class PilaEnlazada {
	
	public Nodo cima;
	
	/**
	 * Constructor de pila enlazada vacía
	 */
	public PilaEnlazada()
	{
		cima = null;
	}
	
	
	/*
	 * X PilaEnlazada(): Inicializa una pila vacía
	 * X push(x): Inserta un elemento en la pila
	 * X pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobación pila vacía
	 * X clear(): Vacía la pila
	 * X peek(): Valor cima de la pila (sin extracción)
	 * X size(): Número de elementos en la pila
	 */
	
	/* 
	 * Operaciones push/pop/peek usan directamente la referencia cima.
	 * Es decir, no es necesario recorrer los nodos.
	 */
	
	/**
	 * Método que comprueba si la pila está vacía
	 * Para ello, comprueba si la cima es null
	 * @return true si la pila está vacía, false si tiene elementos
	 */
	public boolean isEmpty()
	{
		return cima==null;
	}
	
	/**
	 * Método que inserta un elemento en la pila, para ello:
	 * - Crea un nuevo nodo a partir del elemento a insertar
	 * - Inserta el elemento en la cima 
	 * - Cambia la cima
	 * @param elemento El elemento que se desea insertar
	 */
	public void push(Object elemento)
	{
		Nodo nuevo=new Nodo(elemento);
		nuevo.siguiente=cima;
		cima=nuevo;
	}
	
	/**
	 * Método que saca un elemento de la pila, para ello:
	 * - Guarda el elemento en la cima en una variable auxiliar,
	 * - Cambia la cima
	 * - Devuelve el elemento guardado en la variable auxiliar
	 * @return Devuelve el elemento en la cima de la pila
	 * @throws Exception Lanza una excepción si la pila está vacía
	 */
	public Object pop() throws Exception
	{
		if(isEmpty()) throw new Exception("Pila vacía, no se puede extraer.");
		
		Object aux=cima.elemento;
		cima=cima.siguiente;
		return aux;
	}
	
	/**
	 * Método que permite observar el elemento en la cima de la pila (sin extracción)
	 * @return Devuelve el elemento en la cima de la pila
	 * @throws Exception Lanza una excepción
	 */
	public Object peek() throws Exception
	{
		if(isEmpty()) throw new Exception("Pila vacía, no se puede leer la cima.");
		return cima.elemento;
	}
	
	/**
	 * Método que vacía una pila
	 * Para ello, cambia la cima a null
	 */
	public void clear()
	{
		cima = null;
	}
	
	/**
	 * Método que calcula el tamaño de una pila (número de elementos en la pila), para ello:
	 * - Si la pila está vacía, devuelve 0
	 * - En caso contrario:
	 * 		. Accede a la pila mediante la cima
	 * 		. Crea un entero size = 1
	 * 		. Recorre la pila hasta hasta llegar al último, incrementando size
	 * 		. Devuelve size
	 * @return
	 */
	public int size()
	{
		if(isEmpty()) return 0;
		else {			
			Nodo t = cima;
			int size = 1;
			while(t.siguiente != null)
			{
				t = t.siguiente;
				size++;
			}
			return size;
		}
	}

}
