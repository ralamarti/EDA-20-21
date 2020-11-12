package bicola;

import colaEnlazada.*;
import nodo.Nodo;

public class Bicola extends ColaEnlazada {
	
	//extiende la implementación de la clase ColaLista
	
	public Bicola()
	{
		//invoca al constructor de la clase padre
		super();
	}
	
	public void pushEnd(Object elemento)
	{
		push(elemento); //metodo heredado
	}
	
	public void pushFront(Object elemento)
	{
		Nodo a = new Nodo(elemento);
		if(isEmpty())
		{
			fin=a;
		}
		a.siguiente=frente;
		frente=a;
		size++;
	}
	
	public Object popFront() throws Exception
	{
		return pop();
	}
	
	public Object popEnd() throws Exception
	{
		//para quitar del final es necesario recorrer la bicola para situarse en el nodo anterior al final
		Object aux;
		if(!isEmpty())
		{
			
			if(frente==fin) aux=pop(); //si la cola dispone de un sólo elemento
			else
			{
				Nodo actual = frente;
				while(actual.siguiente!=fin) actual=actual.siguiente;

				
				aux=fin.elemento;

				//siguiente del nodo anterior se pone a null
				actual.siguiente=null;
				fin=actual;
			}
		}
		else throw new Exception("Eliminar de una bicola vacía");
		size--;
		return aux;
		
	}
	public Object front() throws Exception
	{
		return front();
	}
	public Object end() throws Exception
	{
		if(isEmpty()) throw new Exception("Error bicola vacía");
		return fin.elemento;
	}

	public int numElemsBicola()
	{
		return size;
	}
}
