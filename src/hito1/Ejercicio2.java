package hito1;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        final Scanner TECLADO = new Scanner(System.in);

        System.out.println("En este programa se calcula el coste de venta de entradas para un concierto.");
        System.out.println("El coste por entrada es de 33€.");
        System.out.print("\nIntroduzca el número de entradas a vender:");
        int m = TECLADO.nextInt();

        if (m <= 0) {
            System.out.println("El número de entradas a vender debe ser positivo. Se cerrará el programa por este error.");
        } else {
            System.out.print("Introduzca el número de entradas a partir del cual se aplicará el 5%:");
            int k1 = TECLADO.nextInt();
            if (k1 <= 0 || k1 >= m - 1) {
                System.out.println("El número debe estar entre 0 y " + (m - 1) + " sin contarlos. Se cerrará el programa por este error.");
            } else {
                System.out.print("Introduzca el número de entradas a partir del cuál se aplicará el 15%:");
                int k2 = TECLADO.nextInt();
                if (k2 <= k1 || k2 >= m) {
                    System.out.println("El número debe estar entre " + k1 + " y " + m + " sin contarlos. Se cerrará el programa por este error.");
                } else {
                    System.out.print("Introduzca el número de entradas a comprar:");
                    int n = TECLADO.nextInt();
                    if (n <= 0 || n > m) { // suponemos que se va a comprar mínimo una entrada
                        System.out.println("El número debe de estar entre 0 y " + (m + 1) + " sin contarlos. Se cerrará el programa por este error.");
                    } else {
                        if (n < k1) {
                            System.out.println("El coste de " + n + " entradas es de " + (n * 33) + "€.");
                        } else if (n < k2) {
                            System.out.println("El coste de " + n + " entradas con un 5% de descuento es de " + (n * 33 * 0.95) + "€.");
                        } else {
                            System.out.println("El coste de " + n + " entradas con un 15% de descuento es de " + (n * 33 * 0.85) + "€.");
                        }
                    }
                }
            }
        }

        System.out.print("\nFin del programa...");
    }

}
