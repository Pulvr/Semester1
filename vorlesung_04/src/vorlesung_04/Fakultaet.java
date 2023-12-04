package vorlesung_04;

import java.util.Scanner;

public class Fakultaet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zahl deren Fakultät berechnet werden soll: ");
        int number = scanner.nextInt();
        scanner.close();

        int counter;
        int solution=1;

        for (counter=1; counter<=number;counter++){
            
            solution = solution * counter;
            
            System.out.println(solution);
        }

        System.out.println("Die Fakultät der Zahl "+number+" beträgt "+solution);
        
    }
}
