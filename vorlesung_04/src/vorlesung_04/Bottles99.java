package vorlesung_04;

//Aufgabe 4 Bottles99 : Florian Wendel - florian.wendel@haw-hamburg.de

public class Bottles99 {
    public static void main(String[] args) {

        int counter = 99;

        // Solange counter nicht 0 ist, den Songtext wiederholen und um 1 verringern
        while (counter != 0) {
            // Extra Argumente, counter!=1 und counter!=2 damit dieser Text nicht ausgegeben wird, wenn
            // counter==2 oder counter ==1 
            if (counter != 0 && counter != 1 && counter != 2) {
                System.out.println(
                        counter + " bottles of beer on the wall, " + counter + " bottles of beer.\n" +
                                "Take one down and pass it around, " + (counter - 1) +" bottles of beer on the wall.\n");

            // Sonderfall bei 2 Bottles, die zweite Zeile enthält nur 1 Bottle also s entfernt
            } else if (counter == 2) {
                System.out.println(
                        counter + " bottles of beer on the wall, " + counter + " bottles of beer.\n" +
                                "Take one down and pass it around, " + (counter - 1) + " bottle of beer on the wall.\n");

            // Sonderfall bei 1 Bottle, Songtext anders 
            } else if (counter == 1) {
                System.out.println(
                        counter + " bottle of beer on the wall, " + counter + " bottle of beer.\n" +
                                "Take one down and pass it around, no more bottles of beer on the wall.\n");
                //letzte Zeile
                System.out.println("No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.");
            }
            //Am ende jeder Bedingung counter um 1 verringern
            --counter;
        }
    }
}
