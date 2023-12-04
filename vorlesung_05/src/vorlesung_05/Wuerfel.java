package vorlesung_05;

import java.util.Scanner;

public class Wuerfel {
    
    enum MyWuerfel {
        EINS, ZWEI, DREI, VIER, FUENF, SECHS
    }
    public static void main(String[] args) {

        
        Scanner myScanner = new Scanner(System.in);
        
        String input;
        
        MyWuerfel[] wuerfelArray = MyWuerfel.values();
        
        int randomSeite = (int) (Math.random()*6);
        
        do{

            System.out.println("Der Würfel zeigt "+ wuerfelArray[randomSeite] + "\nNochmal würfeln? (j/n)?" );
            input = myScanner.nextLine();

            randomSeite = (int) (Math.random()*6);            
            
       }while(input.equals("j"));
            
       myScanner.close();
        
        // MyWuerfel wuerfelState = MyWuerfel.EINS;
        // switch (stateWuerfel) {
        //     case EINS:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     case ZWEI:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     case DREI:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     case VIER:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     case FUENF:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     case SECHS:
        //         System.out.println("Der Würfel zeigt: " + stateWuerfel.toString());
        //         break;
        //     default:
        //         System.err.println("Unzulässige Eingabe");
        //         break;
        // }

    }
}
