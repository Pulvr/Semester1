package vorlesung_01;
import java.util.Scanner;


public class AdditionsProgrammEVA {

	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Geben Sie die erste Zahl ein");
		int myFirstNumber = myScanner.nextInt();
		System.out.println("Geben Sie die zweite Zahl ein");
		int mySecondNumber = myScanner.nextInt();
		
		int added = myFirstNumber + mySecondNumber;
		
		System.out.println("Das Ergebnis ist: "+ added);
		myScanner.close();
	}

}
