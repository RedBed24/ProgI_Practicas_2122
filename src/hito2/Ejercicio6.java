package hito2;
import java.util.Scanner;

public class Ejercicio6 {

	final static Scanner teclado = new Scanner(System.in);
	
	static int leernumintervalo(int LI, int LS) {
		if(LS<LI){
			int cambio=LI;
			LI=LS;
			LS=cambio;
		}
		int z;
		do {
			System.out.print("\nIntroduce un valore entre ["+ LI+", "+ LS+"]:");
			z = teclado.nextInt();
			if (z < LI || z > LS)
				System.out.println("Error el numero debe ser mayor o igual a " + LI + " y menor o igual que " + LS + ".");
		} while (z < LI || z > LS);
		return z;
	}
	
	static int leernumnatural() {
		int n;
		do {
			System.out.print("\nIntroduce un n�mero natural:");
			n = teclado.nextInt();
			if (n < 0)
				System.out.println("Error el numero debe ser positivo.");
		} while (n < 0);
		return n;
	}
	
	static void mostrarvector(boolean[] vect) {
		for(int i=0; i<vect.length; i++)
			System.out.print("  "+vect[i]);
	}
	
	static boolean[][] crearmatrix(boolean b) {
		int N = leernumnatural();
		int M = leernumnatural();
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
	
	static void menu() {
		System.out.println("\nEscribe 1 para introducir un numero en un intervalo, 2 para un n�mero natural,\n3 para mostrar un vector, 4 para crear una matriz, 5 para mostrar una matriz o 6 para contar la matriz");
		int n=leernumnatural();
		
		boolean[][] matrix = new boolean[1][1];
		matrix[0][0]=false;
		// como el gui�n no lo especifica he usado los par�metros que he querido
		
		switch (n) {
		case 1:
			int a=leernumintervalo(0, 0);
			break;
		case 2:
			int b=leernumnatural();
			break;
		case 3:
			boolean[] vector = new boolean[1];
			vector[0]=false;
			mostrarvector(vector);
			break;
		case 4:
			matrix=crearmatrix(false);
			break;
		case 5:
			mostrarmatrix(matrix);
			break;
		case 6:
			int c=cuentamatrix(matrix, false);
			break;
		}
	}
	
	public static void main(String[] args) {
		menu();
		// el ejercicio realiza lo que pide el gui�n, pero en el gui�n falta informaci�n para poder hacer un programa completamente funcional
	}
}
