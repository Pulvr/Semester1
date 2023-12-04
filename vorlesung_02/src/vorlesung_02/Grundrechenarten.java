//Aufgabe 1 Grundrechenarten : Florian Wendel - florian.wendel@haw-hamburg.de

package vorlesung_02;
import java.util.Scanner;

public class Grundrechenarten {

	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		//enter the two float numbers
		System.out.print("Geben Sie die erste Zahl ein: ");
		float myFirstNumber = myScanner.nextFloat();
		System.out.print("Geben Sie die zweite Zahl ein: ");
		float mySecondNumber = myScanner.nextFloat();
		
		//declare all basic arithmetic options
		float added,substracted,multiplied,divided;
		
		//perform all math operations, store into variables
		//and put out the solution
		
		//addition
		added = myFirstNumber + mySecondNumber;
		System.out.println(myFirstNumber+" + "+mySecondNumber + " = " + String.format("%.1f", added));		
		
		//substraction
		substracted = myFirstNumber - mySecondNumber;
		System.out.println(myFirstNumber+" - "+mySecondNumber + " = " + String.format("%.1f", substracted));
		
		//multiplication
		multiplied = myFirstNumber * mySecondNumber;
		System.out.println(myFirstNumber+" * "+mySecondNumber + " = " + String.format("%.1f", multiplied));
		
		//division
		//only divide, if second number is not 0 
		if (mySecondNumber!=0) {
			divided = myFirstNumber / mySecondNumber;
			System.out.println(myFirstNumber+" / "+mySecondNumber + " = " + String.format("%.1f", divided));
		}else {
			System.err.println(myFirstNumber+ " / " + mySecondNumber + " => Teilen durch 0 nicht moeglich" );
		}		
		
		myScanner.close();
	}
}
