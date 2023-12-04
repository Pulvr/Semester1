package vorlesung_03;
//Aufgabe 3 NotenChecker : Florian Wendel - florian.wendel@haw-hamburg.de

import java.util.Scanner;

public class NotenChecker {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Bitte gib deine Note ein");
        int selectedNumber = myScanner.nextInt();
        myScanner.close();

        switch (selectedNumber) {
            case 1:
                System.out.println("mit sehr gut bestanden");
                break;
            case 2:
                System.out.println("mit gut bestanden");
                break;
            case 3:
                System.out.println("mit befriedigend bestanden");
                break;
            case 4:
                System.out.println("mit ausreichend bestanden ");
                break;
            case 5:
                System.out.println("mit mangelhaft nicht bestanden");
                break;
            default:
                System.err.println("ungueltige Note");
                break;
        }

    }
}
