package vorlesung_02;

import java.util.Scanner;

public class SchalterWahl {
    public static void main(String[] args){
        Integer random = (int) (Math.random() * 255);

        //int random1 = 5;
        String outpuString = String.format("%8s", Integer.toBinaryString(random)).replace(' ', '0');
        System.out.println(outpuString);
        
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Wähle welches bit gedreht werden soll (0-7)");
        
        int selectedMove = myScanner.nextInt();
        myScanner.close();

        //shift??
        //Signed Left Shift	<<	The left shift operator moves all bits by a given number of bits to the left.

        int shift = 1 << selectedMove;

        //XOR??
        //ist wohl auch wie eine art toggle, wenn 0 dann 1 und wenn 1 dann 0 ?
        //Vergleicht die Zahlen auf bit ebene und macht dann ein xor auf jedem bit
        //(decimal)    (binary)
        //5     =  101
        //6     =  110
        //-------- xor
        //3     =  011
        int solution = random ^ shift;

        System.out.println(solution);
        outpuString = String.format("%8s", Integer.toBinaryString(solution)).replace(' ', '0');

        System.out.println(outpuString);
    }
}
