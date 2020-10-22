package main;


import listas.Lista;
import listas.Nodo;

public class Main {

	public static void main(String[] args) {
		
		// Creamos nuevo nodo
		// [valor] (enlace)
		// [ 23  ] (null)
		Nodo ultimoNodo = new Nodo(23);
		
		// Creamos nuevo nodo
		// [valor]  (enlace)
		// [ 154  ] (ultimoNodo)
		Nodo miNodo = new Nodo(154, ultimoNodo);
		
		// Crear nueva lista con un nodo (miNodo)
		// 154 --> 23 --> null
		Lista miListaConNodo = new Lista(miNodo);
		
	}

}
