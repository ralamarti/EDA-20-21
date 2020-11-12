package nodo;

public class Nodo {

	//declaramos que los elementos son de tipo Object para que sea una pila genérica
	public Object elemento;
	public Nodo siguiente;
	
	public Nodo(Object x)
	{
		elemento=x;
		siguiente=null;
	}
	
}
