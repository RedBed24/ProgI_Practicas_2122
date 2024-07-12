package examen;

import java.util.Scanner;

public class B2_Espejo_Gil_Samuel {

final static Scanner teclado = new Scanner(System.in);

	static void ocupados(boolean[][] mat) { //ejercicio 1, s�lo usa este m�todo
		for(int i=0; i<mat.length; i++) {
			int cuenta=0;
			for (int j=0; j<mat[i].length; j++) {
				if (!(mat[i][j])) {
					cuenta++;
				}
			}
			if (cuenta==4)
				System.out.println("La fila "+(i+1)+" est� ocupada.");
			else
				System.out.println("La fila "+(i+1)+" tiene "+cuenta+" asientos ocupados.");
		}
	}
	
	static boolean[][] reserva(boolean[][] mat, int f, int p){ //ejercicio 2, s�lo usa este m�todo
		boolean libre=true;
		for (int i=0; i<mat[f].length; i++)
			if (!(mat[f][i]))
				libre=false;
		
		if(libre) {
			for(int i=0; i<mat[f].length; i++)
				mat[f][i]=false;
			System.out.println("\nEl precio final, incluyendo descuento por comprar fila completa es: " + (mat[f].length*p*0.95));
		}
		else
			System.out.println("No se puede reservar la fila ya que est� ocupada.");
		
		return mat;
	}
	
	static int leernumintervalo(int LI, int LS) { //esto ya es parte de la pr�ctica
		if(LS<LI){
			int cambio=LI;
			LI=LS;
			LS=cambio;
		}
		int z;
		do {
			System.out.print("\nIntroduce un valore entre ["+ LI+", "+ LS+"]: ");
			z = teclado.nextInt();
			if (z < LI || z > LS)
				System.out.println("Error el numero debe ser mayor o igual a " + LI + " y menor o igual que " + LS + ".");
		} while (z < LI || z > LS);
		return z;
	}
	
	static int leernumnatural() {
		int n;
		do {
			System.out.print("\nIntroduce un n�mero natural: ");
			n = teclado.nextInt();
			if (n < 0)
				System.out.println("Error el numero debe ser positivo.");
		} while (n < 0);
		return n;
	}
	
	static boolean[][] crearmatrix(boolean b) {
		int N = leernumnatural();
		int M = 4;
		boolean[][] mat = new boolean[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				mat[i][j]=b;
		return mat;
	}
	
	static void mostrarmatrix(boolean[][] mat) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j < mat[i].length; j++)
				System.out.print("  "+mat[i][j]);
			System.out.println();
		}
	}
	
	static int cuentamatrix(boolean[][] mat, boolean b) {
		int cuenta=0;
		for(int i=0; i<mat.length; i++)
			for(int j=0; j < mat[i].length; j++)
				if(mat[i][j]==b)
					cuenta++;
		return cuenta;
	}

	static boolean[][] venta(boolean[][] avion, int p){
		
		//ver cuantos asientos se pueden vender
		if (4*avion.length - cuentamatrix(avion, false) > 10) { // libres = total - anteriormente comprados
			avion = venta(avion, p, 10);
		}
		else if (4*avion.length - cuentamatrix(avion, false) > 0) {
			avion = venta(avion, p, 4*avion.length - cuentamatrix(avion, false));
		}
		else {
			System.out.println("\nError, ya se han comprado todos los asientos.");
		}
		
		return avion;
	}
	
	static boolean[][] venta(boolean[][] avion, int p, int libres) {
		System.out.print("\nIntroduce el n�mero de asientos a comprar: ");
		int comprados = leernumintervalo(1, libres);
		
		int[] filas = new int[comprados];
		int cuenta=0;

		int iter=0;
		while (comprados > iter) {
			int f, c;
			do { //pide especificaci�n del asiento a comprar
				System.out.print("\nIntroduce la fila del asiento " +(iter+1)+" a comprar: ");
				f = leernumintervalo(1, avion.length)-1;
				System.out.print("\nIntroduce n�mero del asiento " +(iter+1)+" a comprar: ");
				c = leernumintervalo(1,4)-1;
				if (!avion[f][c]) {
					System.out.println("Error, el asiento ya est� ocupado.\n");
					mostrarmatrix(avion);
				}
				else
					System.out.println("Se ha comprado el asiento "+(c+1)+" de la fila "+(f+1)+".");
			}while (!avion[f][c]);
			avion[f][c] = false; //se vende
			
			for (int i=0; i< filas.length && cuenta < 4; i++) { //comprobaci�n del descuento
				cuenta=0;
				for (int j=0; j<filas.length && cuenta < 4; j++)
					if (filas[i]==filas[j] && cuenta < 4)
						cuenta++;
			}
			 iter++;
		}
		
		if (cuenta==4)
			System.out.println("\nEl precio final, incluyendo descuento por comprar fila completa es: " + (comprados*p*0.95));
		else
			System.out.println("\nEl precio final (ning�n descuento aplicable) es: " + (double)(comprados*p));
		
		return avion;
	}
	
	static void compruebalibre(boolean[][] avion) {
		System.out.print("\nIntroduce la fila del asiento a comprobar: ");
		int f = leernumintervalo(1, avion.length)-1;
		System.out.print("Introduce el n�mero del asiento a comprobar: ");
		int c = leernumintervalo(1, 4)-1;
		if (avion[f][c])
			System.out.println("\nEl asiento "+(c+1)+" de la fila "+(f+1)+" est� libre.");
		else
			System.out.println("\nEl asiento "+(c+1)+" de la fila "+(f+1)+" est� ocupado.");
	}
	
	static boolean[][] anular(boolean[][] avion) {
		System.out.print("\nIntroduce la fila del asiento a anular: ");
		int f = leernumintervalo(1, avion.length)-1;
		System.out.print("Introduce el n�mero del asiento a anular: ");
		int c = leernumintervalo(1, 4)-1;
		if (avion[f][c])
			System.out.println("\nEl asiento ya est� libre.");
		else
			avion[f][c] = true;
		return avion;
	}
	
	static void menu() {
		System.out.print("\nIntroduzca la cantidad de filas del avi�n:");
		boolean[][] avion = crearmatrix(true);
		System.out.print("\nIntroduzca el precio de los asientos del avi�n:");
		int p=leernumnatural();
		int s;
		do {
			
			System.out.println("\n\nEl autob�s actualmente est� as�:");
			mostrarmatrix(avion);
			
			System.out.println("\n0. Salir\n1. Venta de billetes\n2. Consulta de asientos libres\n3. Anulaci�n de billetes\n4. Reserva de fila\n5. Comprobaci�n de asientos ocupados por fila");
			System.out.print("\nElija una opci�n del men�:");
		
			s=leernumintervalo(0, 5);
			switch (s) {
			case 0:
				break;
			case 1:
				avion = venta(avion, p);
				break;
			case 2:
				compruebalibre(avion);
				break;
			case 3:
				avion = anular(avion);
				break;
			case 4:
				System.out.print("Indica el n�mero de la fila a reservar:");
				int f = leernumintervalo(1, avion.length) - 1;
				avion = reserva(avion, f, p);
				break;
			case 5:
				ocupados(avion);
			}
		}while (s!=0);
	}

	public static void main(String[] args) {
		System.out.println("** Bienvenido al sistema de venta de billetes de avi�n **");
		menu();
		System.out.print("\nFin del programa");
	}
}