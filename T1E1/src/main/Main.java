package main;

import java.util.Scanner;

/* 
 * Introducir los datos de una matriz cuadrada de tamaño prefijado, 
 * indicar dos filas a intercambiar, 
 * intercambiar dichas filas
 * y mostrar el resultado. 
 */

public class Main {

	public static void main(String[] args) {
		
		int dimension = 3;
		
		int[][] matrix = new int[dimension][dimension];
		
		Scanner entrada = new Scanner(System.in);
		
		// Bucle para recorrer matriz
		for(int filas = 0; filas < dimension; filas++) { //Recorrer las filas
			
			for(int columnas = 0; columnas < dimension; columnas++) { //Recorrer columna
				
				// Meter los valores en cada posición
				System.out.println("Give me an int for position [" + filas + "][" + columnas +"]");
				
				matrix[filas][columnas] = entrada.nextInt();
				
			}
			
		}
		
		System.out.println("Give me a row to swap");
		int fila = entrada.nextInt();
		
		System.out.println("Give me a second row to swap");
		int segundaFila = entrada.nextInt();
		
		int[] filaAuxiliar = matrix[fila];
		/*
		 * for(int i = 0; i < dimension; i++) 
		 * 		filaAuxiliar[i] = matrix[fila][i]; 
		 */
		
		// Intercambio de las filas
		matrix[fila] = matrix[segundaFila];
		matrix[segundaFila] = filaAuxiliar;
		
		// Imprimir matrix
		for(int filas = 0; filas < dimension; filas++) { //Recorrer las filas
			// imprimir [
			for(int columnas = 0; columnas < dimension; columnas++) { //Recorrer columna
				
				// Meter los valores en cada posición
				//System.out.println("position [" + filas + "][" + columnas + "] = " + matrix[filas][columnas]);
				System.out.print(matrix[filas][columnas] + "\t");
				
			}
			
			System.out.println();
			// imprimir ]
			
		}
		
		entrada.close();
		
	}

}
