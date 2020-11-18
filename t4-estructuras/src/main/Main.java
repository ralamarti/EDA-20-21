package main;

import colas.*;

public class Main {

	public static void main(String[] args) {
		
		ColaPrioridad cp = new ColaPrioridad(3);
		cp.push(4, 1);
		cp.push(5, 1);
		cp.push(2, 1);
		cp.push(14, 1);

	}

}
