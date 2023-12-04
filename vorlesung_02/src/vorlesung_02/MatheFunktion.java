package vorlesung_02;

import java.util.Scanner;


public class MatheFunktion {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		//enter the two float numbers
		System.out.print("Geben Sie die erste Zahl ein: ");
		float myFirstNumber = myScanner.nextFloat();
		System.out.print("Geben Sie die zweite Zahl ein: ");
		float mySecondNumber = myScanner.nextFloat();
		myScanner.close();
		
		System.out.println("Die Absolutwerte sind: " + Math.abs(myFirstNumber) + ", "+ Math.abs(mySecondNumber));
		System.out.println("Die kleinere Zahl ist: " + Math.min(myFirstNumber, mySecondNumber));
		System.out.println("Beide Zahlen multipliziert sind: " + myFirstNumber * mySecondNumber);
	}
}