package main;

import clases.*;
import listas.Lista;

public class Principal {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		// Creo lista vacía
		Lista listaCompra = new Lista();
		
		// Crear los productos
		Producto cerveza = new Producto(15167, "cerveza", 2);
		Granel conguitos = new Granel(16754, "conguitos", 4, 1.2);
		Unidad pan = new Unidad(4, "pan", 0.8, 2);
		Producto leche = new Producto(1544, "leche", 0.5);
		
		listaCompra.insertHead(pan);		
		listaCompra.insertHead(conguitos);
		listaCompra.insertHead(cerveza);
		
		//listaCompra.insertLast(leche);
		
		listaCompra.insertAtPosition(leche, 2);
		
	}

}
