package vorlesung_04;

public class DurchlaufZaehler {
    public static void main(String[] args){

        int binaryNumber=1;
        int counter=1;

        while (counter<11) {
            System.out.println(counter+". Durchlauf: "+ binaryNumber);

            binaryNumber = binaryNumber << 1;

            counter++;
        }
    }
}
