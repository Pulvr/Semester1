package vorlesung_04;

import java.util.Scanner;

public class Passwortabfrage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries = 3;
        String password;

        do{
            System.out.print("Passwort ("+(4-tries)+". Versuch ) :");
            password = scanner.nextLine();

            if (password.equals("Java")) {
                System.out.println("Zutritt gewährt");
            }else{
                System.out.println("Das war nicht korrekt");
                tries--;
            }
        }while (tries>0 && !password.equals("Java"));

        scanner.close();
    }
}
