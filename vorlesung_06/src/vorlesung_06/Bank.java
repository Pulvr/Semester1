package vorlesung_06;


public class Bank {

    public static void main(String[] args) {

        Konto myKonto = new Konto();

        System.out.println("Der Besitzer ist: " + myKonto.besitzer + " mit Kontostand " + myKonto.kontostand);

        myKonto.besitzer = "brudi";
        myKonto.kontostand = 230f;
        
        Konto neueKonto = new Konto("John Doe", 5000.00f);
        Konto dritteKonto = new Konto("Bro", 200.0f);

        System.out.println(neueKonto.besitzer + " : " + neueKonto.kontostand);

        neueKonto.einzahlen();

        neueKonto.einzahlen(300.0f);

        System.out.println(neueKonto.toString());
        System.out.println(dritteKonto.toString());

        System.out.println(Konto.zinsenToString());

        neueKonto.jahresAbschluss();

        System.out.println(Konto.kontoList.get(1));

        Konto.staticJahresAbschluss();
        
    }
}