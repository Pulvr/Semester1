package vorlesung_05;

//Aufgabe 5 ExtremwerteSortierung : Florian Wendel - florian.wendel@haw-hamburg.de

public class ExtremwerteSortierung {
    public static void main(String[] args) {

        // Ein Array mit einer Größe von 20 Werten initialisieren
        int[] randomArray = new int[20];

        // Array mit pseudo-zufälligen Zahlen zwischen 0 und 100 füllen und ausgeben
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 100);
            System.out.print(randomArray[i] + " ");
        }

        int helper = 0; // temporäre Variable zum Zwischenspeichern der Werte

        for (int i = 0; i < randomArray.length; i++) { // Einmal Array komplett durchlaufen

            // innere Schleife damit die Array Werte miteinander verglichen werden können
            // Angefangen bei eins, damit wir nicht array out of bounds bekommen
            // Die Schleife läuft so lange, wie die Länge des Arrays - i ,
            // beim Bubble Sort landen die größten Werte am Ende des Arrays
            // es ist also nicht notwendig, immer wieder das ganze Array zu durchlaufen.
            for (int j = 1; j < (randomArray.length - i); j++) {

                // Wenn die Zahl an bspw. Stelle 0 größer ist als an Stelle 1, vertausche die
                // Werte
                if (randomArray[j - 1] > randomArray[j]) {
                    helper = randomArray[j - 1]; // erst zwischenspeichern
                    randomArray[j - 1] = randomArray[j]; // der Wert an Stelle 0 wird zum Wert an Stelle 1
                    randomArray[j] = helper; // der Wert an Stelle 1, wird der vorher gespeicherte
                }

                // so wird fortgefahren, bis die größte Zahl am Ende vom Array und die kleinste
                // am Anfang von Array ist
            }
        }

        System.out.println("\n"); // Satzumbruch

        // Sortiertes Array ausgeben
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }

    }
}
