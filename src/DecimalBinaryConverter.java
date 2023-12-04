package src;

import java.util.Scanner;

class DecimalBinaryConverter 
{
    public static void main (String[] args)
    {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Geben Sie eine ganze Dezimalzahl ein");
        int decimal = myScanner.nextInt();
        myScanner.close();

        //converts decimal to binary in string format
        String binaryString = Integer.toBinaryString(decimal);
        
        //create array with lenth of binary number ( with int maximum would be 31 )
        int[] binaryBits = new int[binaryString.length()];

        //counts up to iterate through the array
        int counter=0;

        while( decimal!=0 ){
            //start at zero, store if value is 0 or 1
            binaryBits[counter] = decimal % 2;
            
            counter++;
            
            decimal = decimal / 2; 
            
        }

        //iterate through the array from highest to lowest
        for (int i = binaryString.length()-1  ; i>=0 ; i--){
            System.out.print(binaryBits[i]);
        }
        System.out.println("\n"+binaryString);
    }
}
