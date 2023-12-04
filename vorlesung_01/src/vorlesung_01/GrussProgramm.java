package vorlesung_01;

import java.util.Scanner;

public class GrussProgramm {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Geben Sie Ihren Vornamen ein ");
		String name = myScanner.next();
		System.out.println("Geben Sie Ihren Nachnamen ein");
		String surname = myScanner.next();
		
		//Whitespace added to seperate names from each other
		String fullName = name +" "+ surname;
		
		System.out.println("Willkommen: "+ fullName+"!");
		myScanner.close();

	}

}
