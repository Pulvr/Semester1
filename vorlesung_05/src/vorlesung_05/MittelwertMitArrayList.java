package vorlesung_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MittelwertMitArrayList {
    public static void main(String[] args) {

        List<Float> MittelWertList = new ArrayList<Float>();

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Möchten Sie einen neuen Wert hinzufügen?(y/n)");
        String loopInput = myScanner.nextLine();
        int counter = 1;
        float input;
        float sum = 0.0f;
        float mittelwert = 0.0f;
        
        while (loopInput.equals("y") || loopInput.equals("Y")) {
            
            System.out.println("Bitte geben Sie einen Wert ein");
            System.out.print(counter + ". Element: ");
            
            input = myScanner.nextFloat();
            MittelWertList.add(input);
            
            for (int i = 0; i < MittelWertList.size(); i++) {
                System.out.print(MittelWertList.get(i)+" ");
                sum += MittelWertList.get(i);
            }

            mittelwert = sum / MittelWertList.size();
            System.out.println(" - Mittelwert: " + String.format("%.2f", mittelwert) + " Möchten Sie einen neuen Wert hinzufügen?(y/n)");
            
            loopInput = myScanner.next();
            counter++;

        }
        myScanner.close();
    }
}
