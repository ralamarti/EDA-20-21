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
		
		// Bucle para recorrer una matriz
		for(int filas = 0; filas < dimension; filas++) {
			
			for(int columnas = 0; columnas < dimension; columnas++) {
				
				// Pedir entrada al usuario
				System.out.println("Give me the value for position [" + filas + "][" + columnas + "]");
				// Recuperar desde teclado
				matrix[filas][columnas] = entrada.nextInt();
			}
			
		}
		
		// Pedimos dos filas para intercambiar
		System.out.println("Give me the first row to swap");
		int firstRow = entrada.nextInt();
		System.out.println("Give me the second row to swap");
		int secondRow = entrada.nextInt();
		
		// Intercambio de arrays
		int[] filaAuxiliar = matrix[firstRow];
		matrix[firstRow] = matrix[secondRow];
		matrix[secondRow] = filaAuxiliar;
		
		
		/* Bucle para intercambiar valores
		int[] filaAuxiliar = new int[dimension];
		for(int i = 0; i < dimension; i++) {
			filaAuxiliar[i] = matrix[firstRow][i];
			matrix[firstRow][i] = matrix[secondRow][i];
			matrix[secondRow][i] = filaAuxiliar[i];
		}
		*/
		
		
		// Bucle para escribir matriz por consola
		for(int filas = 0; filas < dimension; filas++) 
		{
			for(int columnas = 0; columnas < dimension; columnas++)
			{
				// Pedir entrada al usuario
				//System.out.println("Value for position [" + filas + "][" + columnas + "] = " + matrix[filas][columnas]);
		
				System.out.print(matrix[filas][columnas] + "\t");
			}
			System.out.println();
		}
		
		entrada.close();
				
	}

}

