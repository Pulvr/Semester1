package vorlesung_04;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int firstNumber=1;
        int secondNumber=1;
        int sum=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wie viele Elemente der Fibonacci-Folge sollen ausgegeben werden?");

        int amountFibonacci = scanner.nextInt();

        //Zuerst vor der Berechnung unabhängig von der Schleife die erste Zahl der Fibonacci folge ausgeben
        System.out.print(firstNumber+" ");
        
        //solange durchlaufen, bis die Eingabe erreicht wird
        for (int counter = 1; counter<amountFibonacci; counter++){

            //zuerst die Summe aus beiden Zahlen bilden
            sum=firstNumber+secondNumber;
            
            //die erste Zahl ist die zweite Zahl
            firstNumber = secondNumber;
            //Die zweite Zahl ist die Summe der beidne davor
            secondNumber = sum;
            
            System.out.print(firstNumber+" ");
        }
        scanner.close();
    }
}
