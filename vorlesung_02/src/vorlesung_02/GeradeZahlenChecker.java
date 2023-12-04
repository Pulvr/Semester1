package vorlesung_02;

import java.util.Scanner;

public class GeradeZahlenChecker {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Geben Sie eine beliebige, gerade Ganzzahl ein: ");
		int number = myScanner.nextInt();
		myScanner.close();

		// wenn das ergebnis 0 ist, dann gerade, ansonsten ungerade
		boolean even = number % 2 == 0;

		System.out.println(even);
	}

}
