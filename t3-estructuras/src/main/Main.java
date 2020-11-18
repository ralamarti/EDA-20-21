package main;

import listas.*;

public class Main {

	public static void main(String[] args) {
		try {


			ListaDobleCircular miLista = new ListaDobleCircular();

			int size = miLista.size();
			miLista.insert(5);
			size = miLista.size();
			miLista.insert(2);
			size = miLista.size();
			miLista.insert(13);
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
