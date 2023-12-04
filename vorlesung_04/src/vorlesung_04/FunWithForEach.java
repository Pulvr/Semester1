package vorlesung_04;

public class FunWithForEach {
    public static void main(String[] args) {
        int[] arr = {1,5,2,5,7};

        int arrayLength=0;
        int arraySum=0;
        int arrayEvens=0;
        int arrayDupes=0;

        //Für for each braucht man keinen eigenen Zähler durchlauf
        //Einfach den Counter nehmen als Laufzahl, dieser hat den Wert des aktuellen punktes im array
        for (int counter : arr){

            arrayLength+=1;

            arraySum += counter;

            if(counter%2 == 0){
                arrayEvens+=1;
            }
            /* 
            for (int x=0;x<arr.length;x++){
                if (arr[x]==counter) {
                    System.out.println("dupe found "+arr[x]+" and "+counter);
                    arrayDupes+=1;
                }
            }
            */
        }
        
        System.out.println("count: " + arrayLength);
        System.out.println("sum: " + arraySum);
        System.out.println("evens: " + arrayEvens);
        System.out.println("multiple: " + arrayDupes);


    }
}
