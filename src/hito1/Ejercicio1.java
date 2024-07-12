package hito1;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        int num, porc;

        final Scanner TECLADO = new Scanner(System.in);

        System.out.println("Este programa calcula el 95%, 85% y el porcentaje que quieras de un número que introduczcas.");

        System.out.print("\nEcribe el número:");
        num = TECLADO.nextInt();

        System.out.print("Escribe el porcentaje que quieras calcular:");
        porc = TECLADO.nextInt();

        System.out.println("El 95% de " + num + " es " + (num * 95 / 100));
        System.out.println("El 85% de " + num + " es " + (num * 95 / 100));
        System.out.println("El " + porc + "% de " + num + " es " + (num * porc / 100));

        System.out.println("\nAhora se recalculará como números reales:");

        System.out.println("\nEl 95% de " + num + " es " + ((double) num * 95 / 100));
        System.out.println("El 85% de " + num + " es " + ((double) num * 95 / 100));
        System.out.println("El " + porc + "% de " + num + " es " + ((double) num * porc / 100));

        System.out.print("\nFin del programa...");
    }
}
