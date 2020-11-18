package colas;

import nodo.Nodo;

public class ColaEnlazada {

	public Nodo frente;
	public Nodo fin;
	
	public int size;
	
	/**
	 * Constructor de cola vacía
	 */
	public ColaEnlazada()
	{
		frente=null;
		fin=null;
		size = 0;
	}
	
	/*
	 * X ColaEnlazada(): Inicializa una cola vacía
	 * X push(x): Inserta un elemento al final de la cola
	 * X pop(): Extrae un elemento del principio de la cola
	 * X isEmpty(): Comprobación cola vacía
	 * X clear(): Vacía la cola
	 * X front(): Valor frente de la cola (sin extracción)
	 * X end(): Valor final de la cola (sin extracción)
	 * X size(): Número de elementos en la cola
	 */
	
	public void push(Object elemento)
	{
		Nodo a=new Nodo(elemento);
		if(isEmpty())
		{
			frente=a;
		}
		else
		{
			fin.siguiente=a;
		}
		fin=a;
		size++;
	}

	/**
	 * Método que comprueba si una cola está vacía
	 * Para ello, comprueba si el frente es null
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}
	
	public Object pop() throws Exception
	{
		Object aux;
		if(!isEmpty())
		{
			aux=frente.elemento;
			frente=frente.siguiente;
			size--;
		}
		else throw new Exception("Eliminar de una cola vacía");
		
		return aux;
	}
	
	public void clear()
	{
		frente=null;
		size = 0;
		System.gc();
	}
	
	public Object front() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Error: la cola está vacía");
		}
		return frente.elemento;
	}
	
	public Object end() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Error: la cola está vacía");
		}
		return fin.elemento;
	}

}
