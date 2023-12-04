package vorlesung_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konto {

    String besitzer;
    double kontostand;
    static double zinsen = 0.25;

    Scanner sc = new Scanner(System.in);

    public static List<Konto> kontoList = new ArrayList<Konto>();

    // Konstruktoren
    Konto() {
        this.kontostand = 0.0;
        Konto.kontoList.add(this);
    }

    Konto(String besitzer, double kontostand) {
        this.besitzer = besitzer;
        this.kontostand = kontostand;

        Konto.kontoList.add(this);
    }

    // Methoden
    void einzahlen() {
        System.out.println("Aktueller Kontostand ist: " + this.kontostand + " wieviel einzahlen?");
        double temporary = sc.nextFloat();
        if (temporary <= 0) {
            System.out.println("Einzahlung ist negativ! ABBRUCH");
        } else {
            this.kontostand += temporary;
        }
        System.out.println("Kontostand nach einzahlung ist: " + this.kontostand);
    }

    void einzahlen(float einzahlung) {
        System.out.println("Aktueller Kontostand ist: " + this.kontostand + " wieviel einzahlen?");
        if (einzahlung <= 0) {
            System.out.println("Einzahlung ist negativ! ABBRUCH");
        } else {
            this.kontostand += einzahlung;
        }

        System.out.println("Kontostand nach einzahlung ist: " + this.kontostand);
    }

    public String toString() {
        String kontoString = this.besitzer + " - " + this.kontostand;
        return kontoString;
    }

    static String zinsenToString() {
        String zinsString = "Zinssatz: " + zinsen + "%";
        return zinsString;
    }

    // Jahresabschluss für ein einzelnes Konto
    void jahresAbschluss() {

        double tempZins = this.kontostand * zinsen;
        this.kontostand += tempZins;

        System.out.println(
                this.besitzer + ": Ihr Konto hat zum Ende des Jahres wegen der " + zinsen + "% Zinsen den Stand: "
                        + this.kontostand);
    }

    // Jahresabschluss der Klasse, macht es für die gesamte ArrayList
    public static void staticJahresAbschluss() {
        for (int i = 0; i < Konto.kontoList.size(); i++) {
            Konto.kontoList.get(i).jahresAbschluss();
        }
        
        //Mit For each
        /* 
        for (Konto k : kontoList){
            k.jahresAbschluss();
        }
        */
    }
}