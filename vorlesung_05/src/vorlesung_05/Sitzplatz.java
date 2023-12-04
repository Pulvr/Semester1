package vorlesung_05;

import java.util.Scanner;

public class Sitzplatz {
    public static void main(String[] args) {
        //Scanner erstellen Sitzplan mit 5 Reihen und 10 Sitzen erstellt
        Scanner scanner = new Scanner(System.in);
        int[][] seating = new int[5][10];

        //Werte abfragen
        System.out.print("Reihe (1-5): ");
        int row = scanner.nextInt();

        System.out.print("Sitz (1-10): ");
        int seat = scanner.nextInt();

        //Prüfen ob Werte im Rahmen liegen
        if (seat < 1 || seat > 10 || row < 1 || row > 5) {
            System.err.println("Reihe oder Sitz ist nicht vorhanden!");
        } else {
            //eingegebenen Wert zuweisen -1 wegen dem Index
            seating[row - 1][seat - 1] = 1;

            //Über einen Zähler das Array durchlaufen, Default Werte des Arrays ist 0 
            int counter = 0;

            for (int i = 0; i < seating.length; i++) {
                for (int j = 0; j < seating[i].length; j++) {
                    
                    System.out.print(seating[i][j]);
                    counter++;
                    
                    //Wenn der Zähler durch 10 teilbar ist, Umbruch einfügen
                    if (counter % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        }
        scanner.close();
    }
}
