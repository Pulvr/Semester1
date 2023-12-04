package vorlesung_01;
import java.util.Scanner;

public class DivisionsProgrammEVA {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		
		System.out.println("DIVISION\nGeben Sie die erste Zahl ein");
		float myFirstNumber = myScanner.nextFloat();
		System.out.println("Geben Sie die zweite Zahl ein");
		float mySecondNumber = myScanner.nextFloat();
		
		float divided = myFirstNumber / mySecondNumber;

		//Output of division, rounded to 2 points after the decimal
		System.out.println("Das Ergebnis ist: "+ String.format("%.2f", divided));
		myScanner.close();

	}

}
