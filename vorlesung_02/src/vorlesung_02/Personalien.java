//Aufgabe 2 Personalien : Florian Wendel - florian.wendel@haw-hamburg.de
package vorlesung_02;

import java.util.Scanner;

public class Personalien {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// create new stringbuilder, declare to a maximum size of 150
		StringBuilder stringBuilder = new StringBuilder(150);

		// get information, safe to string, append to stringBuilder
		System.out.println("Geben Sie Ihren Vornamen ein");
		String name = scanner.nextLine();
		stringBuilder.append(name);

		System.out.println("Geben Sie Ihren Nachnamen ein");
		String surname = scanner.nextLine();
		stringBuilder.append(surname);
		stringBuilder.append("; ");

		System.out.println("Geben Sie Ihr Geschlecht ein");
		String sex = scanner.nextLine();
		stringBuilder.append(sex);
		stringBuilder.append("; ");

		System.out.println("Geben Sie Ihr Geburtsdatum ein");
		String date = scanner.nextLine();
		stringBuilder.append(date);
		stringBuilder.append("; ");

		System.out.println("Geben Sie Ihren Beruf ein");
		String job = scanner.nextLine();
		stringBuilder.append(job);
		
		// output final string and scanner close
		System.out.println(stringBuilder.toString());

		scanner.close();
	}

}
