package vorlesung_02;

import java.util.Scanner;

public class WerteBereichsChecker {

	public static void main(String[] args) {

		// random gibt eine zahl von 0.0 bis 1.0 zurück, das mal 100 für einen "random"
		// wert zwischen 0 und 100
		int random1 = (int) (Math.random() * 100);
		int random2 = (int) (Math.random() * 100);

		// sicherstellen, dass die kleinere Zahl in min und die größere in max
		// gespeichert wird
		int min = Math.min(random1, random2);
		int max = Math.max(random1, random2);

		Scanner myScanner = new Scanner(System.in);

		System.out.print("Geben Sie eine beliebiege Ganzzahl zwischen " + min + " und " + max + " an: ");

		int number = myScanner.nextInt();
		myScanner.close();

		// Random r = new Random();
		// int low = (int) (Math.random() * 100);
		// int result = r.nextInt(low, high);

		boolean check = number >= min && number <= max;

		System.out.println(check);

	}

}
