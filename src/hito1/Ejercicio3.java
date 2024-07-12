package hito1;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        final Scanner teclado = new Scanner(System.in);

        final int k1 = 5, k2 = 15;
        int min = k1, max = k2; // he usado estas variables porque no me quedaba claro qué variables tenían que ser finales, de esta forma me aseguro
        int n, valor, errores = 0, dentro = 0;

        if (min > max) {
            int cambio = min;
            min = max;
            max = cambio;
        }

        final int limiteinferior = min, limitesuperior = max; // he usado estas variables porque no me quedaba claro qué variables ten�an que ser finales, de esta forma me aseguro

        System.out.println("Este programa te indica si los números positivos que introduzcas están dentro de un rango [" + limiteinferior + "," + limitesuperior + "].");

        do {
            System.out.print("\nIndica el número de datos que vas a introducir:");
            n = teclado.nextInt();

            if (n < 1)
                System.out.println("Error, el numero debe ser positivo.");

        } while (n < 1);

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("\nEscribe el valor " + (i + 1) + ":");
                valor = teclado.nextInt();

                if (valor < 1) {
                    System.out.println("Error, el valor debe ser positivo.");
                    errores++;
                }

            } while (valor < 1);

            if (valor >= limiteinferior && valor <= limitesuperior) {
                System.out.println("El valor " + valor + " está en el intervalo [" + limiteinferior + "," + limitesuperior + "].");
                dentro++;
            }

        }

        System.out.println("\nSe han leido " + (n + errores) + " números enteros, de los cuales " + errores + " han sido erróneos.");
        System.out.println("De los números leídos había " + dentro + " dentro del intervalo [" + limiteinferior + "," + limitesuperior + "].");

        System.out.print("\nFin del programa...");
    }

}
