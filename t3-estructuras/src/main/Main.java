package main;

import listas.*;

public class Main {

	public static void main(String[] args) {
		try {


			ListaDoble miLista = new ListaDoble();

			miLista.insertLast(5);
			miLista.insertLast(2);
			miLista.insertLast(13);

			miLista.clear();

			int size = miLista.size();
			miLista.insertHead(5);
			size = miLista.size();
			miLista.insertHead(2);
			size = miLista.size();
			miLista.insertHead(13);
			size = miLista.size();
			
			miLista.insertAfter(9, 2);			
			
			miLista.remove(2);
			
			
			/* Testing excepciones */
			
			miLista.clear();
			//miLista.insertAfter(7, 14);
			//miLista.first();
			//miLista.last();


		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
