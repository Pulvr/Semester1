package vorlesung_05;

import java.util.Scanner;

public class Mittelwert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anzahl der Messwerte eingeben: ");
        
        int arrayLength = (scanner.nextInt());
        float sum = 0;

        //float array mit der groesse der eingegebenen Zahl initialisieren
        //default Werte jedes Eintrags noch 0.0
        float[] measurements = new float[arrayLength];

        for(int counter = 0; counter<arrayLength; counter++){
            //Counter +1 damit die Anzeige bei 1 beginnt
            System.out.print(counter+1 +". Messwert: ");
            measurements[counter]=scanner.nextFloat();
            sum += measurements[counter];
        }
        
        System.out.println("Mittelwert: "+ String.format("%.2f", sum/arrayLength));
        scanner.close();
    }
    
} 