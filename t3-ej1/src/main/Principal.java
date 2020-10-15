package main;

import clases.*;
import tools.Lista;

public class Principal {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		// Creo lista vacía
		Lista listaCompra = new Lista();
		
		// Crear los productos
		Producto ambientador = new Producto(14980, "ambientador", "limpieza", 3.55);
		Granel pollo = new Granel(15400, "pollo", "comida", 6.75, 3.5);
		Unidades manzana = new Unidades(14, "manzana", "comida", 3.5, 15);
		
		listaCompra.insertHead(ambientador);
		listaCompra.insertHead(pollo);
		listaCompra.insertHead(manzana);

		
	}

}
