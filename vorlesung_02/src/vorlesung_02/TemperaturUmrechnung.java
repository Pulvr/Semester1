package vorlesung_02;

import java.util.Scanner;

public class TemperaturUmrechnung {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.println("Geben Sie eine Temperatur in Grad Celsius ein: ");
		float celsius = myScanner.nextFloat();
		myScanner.close();

		System.out.println(celsius + "°C entsprechen " + fahrenheit(celsius) + "°F und " + kelvin(celsius) + "K");
	}

	static float fahrenheit(float f) {
		return (f * 9 / 5 + 32);
	}

	static float kelvin(float f) {
		return f + 273.15f;
	}
}