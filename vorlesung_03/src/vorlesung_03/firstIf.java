package vorlesung_03;

import java.util.Scanner;

public class firstIf {
        public static void main(String[] args) {

                Scanner myScanner = new Scanner(System.in);
                
                System.out.println("Bitte gib \"hello\" ein ");
                String inpuString = myScanner.nextLine();
                myScanner.close();
                
                if (inpuString.equals("hello")) {
                        System.out.println("Das war korrekt");
                }else{
                        System.out.println("Das war falsch");
                }
        }

}
