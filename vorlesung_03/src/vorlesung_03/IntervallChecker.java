package vorlesung_03;

import java.util.Scanner;

public class IntervallChecker {
        public static void main(String[] args) {

                Scanner myScanner = new Scanner(System.in);
                
                System.out.println("Bitte gib eine Zahl aus dem Intervall [10,20] ein");
                int selectedNumber = myScanner.nextInt();
                myScanner.close();
                

                //Mit Hilfsvariable
                boolean isInterval= 10<= selectedNumber && selectedNumber<=20;

                if(isInterval){
                        System.out.println("das war korrekt");
                }else{
                        System.out.println("das war falsch");
                }

        }
}
