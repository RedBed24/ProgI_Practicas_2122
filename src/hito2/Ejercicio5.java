package hito2;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {

		final Scanner teclado = new Scanner(System.in);

		System.out.println("Este programa calcula si se puede comprar asientos de un autob�s:");

		int F, A;

		do {
			System.out.print("\nIndica la cantidad de filas disponibles: ");
			F = teclado.nextInt();
			System.out.print("\nIndica la cantidad de asientos disponibles por fila: ");
			A = teclado.nextInt();
			if (F < 1 || A < 1)
				System.out.println("Error el numero de asientos y filas debe ser mayor o igual a 1");
		} while (F < 1 || A < 1);

		boolean[][] asientos = new boolean[F][A];

		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = true;
				System.out.print("  " + asientos[i][j]);
			}
			System.out.println();
		}

		int comprados = 0;
		int comprar;

		do {

			do {
				System.out.print("\nIndica la cantidad de asientos a comprar (entre 1 y " + (F * A - comprados) + "), 0 para finalizar el programa: ");
				comprar = teclado.nextInt();
				if (comprar < 0 || comprar > F * A - comprados)
					System.out.println("Error, el numero de asientos a comprar debe ser mayor o igual a 0 y menor o igual que el n�mero de asientos libres (" + (F * A - comprados) + ").");
			} while (comprar < 0 || comprar > F * A - comprados);

			comprados = comprados + comprar;

			if (comprar != 0) {
				System.out.println("Se pueden comprar " + comprar + " asientos:");

				if (comprados == A * F)
					System.out.println("\nSe han ocupado todos los asientos.");
				else {

					int cuenta = 0, fila = -1;

					for (int i = 0; i < asientos.length && cuenta < comprar; i++) {
						cuenta = 0;
						for (int j = 0; j < asientos[i].length && cuenta < comprar; j++)
							if (asientos[i][j]) {
								cuenta++;
								if (cuenta == comprar) {
									fila = i;
								}
							}
					}

					cuenta = 0;

					if (fila < 0) { //este if se podr�a meter dentro del primer bucle, esto har�a que se puedieran juntar los 3 bucles, pero creo que as� es m�s eficiente ya que la evaluaci�n de la condici�n solo se realiza una vez, si se hace dentro del bucle se hace asientos.length veces
						for (int i = 0; i < asientos.length && cuenta < comprar; i++)
							for (int j = 0; j < asientos[i].length && cuenta < comprar; j++)
								if (asientos[i][j]) {
							 		asientos[i][j] = false;
									cuenta++;
								}
					} else
						for (int j = 0; j < asientos[fila].length && cuenta < comprar; j++)
							if (asientos[fila][j]) {
								asientos[fila][j] = false;
								cuenta++;
							}

					for (int i = 0; i < asientos.length; i++) {
						for (int j = 0; j < asientos[i].length; j++) {
							System.out.print("  " + asientos[i][j]);
						}
						System.out.println();
					}
				}
			}
		} while (comprar != 0 && comprados != A * F);

		System.out.print("\nFin del programa...");
	}
}
