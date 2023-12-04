package vorlesung_06;

import java.util.Scanner;

public class Motorrad {
    // Enums für die Farbe und Typ definiert um die möglichen Werte abzubilden
    enum Type {SPORTLER, CHOPPER, CRUISER, ENDURO};
    enum Farbe {SCHWARZ, ROT, BLAU, SILBER}

    // Attribute
    private Type typ;
    private Farbe farbe;
    private int hubraum;

    // Konstruktoren
    Motorrad() {
    }

    Motorrad(Type typ, Farbe farbe, int hubraum) {
        this.typ = typ;
        this.farbe = farbe;
        this.hubraum = checkHubraum(hubraum);
    }

    // Methoden
    void schreibeInfos() {
        System.out.println("Typ: " + this.typ + "\nFarbe: " + this.farbe + "\nHubraum: " + this.hubraum);
        System.out.println("Steuern pro Jahr: " + String.format("%.2f", this.berechneSteuern()) + " Euro\n");
    }

    // Methode zum Steuern berechnen, wird in schreibeInfos() ausgeführt
    double berechneSteuern() {
        double steuern = (this.hubraum / 25) * 1.84;
        return steuern;
    }

    // Methode zum expliziten und implizten prüfen des Hubraums
    private int checkHubraum(int hubraum) {
        if (hubraum < 125) {
            System.out.println("Hubraum darf nicht kleiner als 125 sein!\nKleinster default Wert 125 gesetzt");
            hubraum = 125;
        } else if (hubraum > 1300) {
            System.out.println("Hubraum darf nicht größer als 1300 sein!\nGrößter default Wert 1300 gesetzt");
            hubraum = 1300;
        }
        return hubraum;
    }

    public static void main(String[] args) {
        
        // Scanner für die explizite Eingabe
        Scanner sc = new Scanner(System.in);

        // implizite Erstellung mit vorgegebenen Werten.
        Motorrad erstesBike = new Motorrad(Type.CHOPPER, Farbe.BLAU, 1301);

        // Leeres Bike erstellt, Werte werden durch User Abfrage gefüllt
        Motorrad zweitesBike = new Motorrad();

        System.out.println("Geben Sie den Motorrad Typ an, mögliche Eingaben sind: \n's' Sportler\n'ch' Chopper\n'cr' Cruiser\n'e' Enduro\n");
        String inputStringType = sc.nextLine();
        System.out.println();
        switch (inputStringType) {
            case "s": case "S":
                zweitesBike.typ = Type.SPORTLER;
                break;
            case "ch": case "Ch": case "CH": case "cH":
                zweitesBike.typ = Type.CHOPPER;
                break;
            case "cr": case "Cr": case "CR": case "cR":
                zweitesBike.typ = Type.CRUISER;
                break;
            case "e": case "E":
                zweitesBike.typ = Type.ENDURO;
                break;
            default:
                System.err.println("Ungültige Eingabe!");
            break;
        }
        
        System.out.println("Geben Sie die Farbe des Motorrads ein, mögliche Eingaben sind: \n'sc' Schwarz\n'r' Rot\n'b' Blau\n'si' Silber\n");
        System.out.println();
        String inputStringColor = sc.nextLine();

        switch (inputStringColor) {
            case "sc": case "Sc": case "SC": case "sC":
                zweitesBike.farbe = Farbe.SCHWARZ;
                break;
            case "b": case "B": 
                zweitesBike.farbe = Farbe.BLAU;
                break;
            case "r": case "R":
                zweitesBike.farbe = Farbe.ROT;
                break;
            case "si": case "Si": case  "SI": case "sI":
                zweitesBike.farbe = Farbe.SILBER;
                break;
            default:
                System.err.println("Ungültige Eingabe!");
                break;
        }

        System.out.println("Geben Sie den Hubraum ein, in einem Bereich von 125cc bis 1300cc");
        int userInputHubraum = sc.nextInt();

        zweitesBike.hubraum = zweitesBike.checkHubraum(userInputHubraum);

        Motorrad drittesBike = new Motorrad(Type.CRUISER, Farbe.ROT, 1234);

        erstesBike.schreibeInfos();
        zweitesBike.schreibeInfos();
        drittesBike.schreibeInfos();

        sc.close();
    }
}