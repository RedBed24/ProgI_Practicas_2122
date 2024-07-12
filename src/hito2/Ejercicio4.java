package hito2;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		final Scanner teclado = new Scanner(System.in);
		
		System.out.println("Este programa calcula si se puede comprar asientos de un autob�s:");
		
		int N;
		
		do {
			System.out.print("\nIndica la cantidad de asientos disponibles por fila: ");
			N = teclado.nextInt();
			if (N<1)
				System.out.println("Error el numero de asientos debe ser mayor o igual a 1");
		}while(N<1);
		
		boolean[] asientos = new boolean[N];
		
		for (int i=0; i<asientos.length; i++){ 
		     asientos[i]=true; 
		     System.out.print("  "+asientos[i]);
		}
		
		int M=0;
		int d;
		
		do {
			do {
				System.out.print("\nIndica la cantidad de asientos a comprar (entre 1 y " + (N-M) + "), 0 para finalizar el programa: ");
				d = teclado.nextInt();
				if (d<0 || d>asientos.length-M)
					System.out.println("Error el numero de asientos a comprar debe ser mayor o igual a 0 y menor o igual que el n�mero de asientos libres (" + (N-M) + ").");
			}while(d<0 || d>asientos.length-M); 
		
			M = M + d;
			
			if (d != 0) {
				System.out.println("Se pueden comprar " + d + " asientos.");
				if (M == asientos.length)
					System.out.println("\nSe han ocupado todos los asientos.");
				else 
					for (int i=0; i<asientos.length; i++){ 
						if (i<M)
							asientos[i]=false; 
						System.out.print("  "+asientos[i]);
					}
				}
			}while(d!=0 && M != asientos.length);
		
		System.out.print("\nFin del programa...");
	}
}
