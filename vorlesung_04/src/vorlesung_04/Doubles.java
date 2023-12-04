package vorlesung_04;

public class Doubles {
    public static void main(String[] args){

        int number=1;
        StringBuilder stringBuilder = new StringBuilder();
        
        while(number<=128){

            stringBuilder.append(number);

            //Komma nur anhängen, wenn die letzte Zahl kleiner ist als 128
            if (number<128) {
                stringBuilder.append(", ");
            }
            number*=2;

        }

        System.out.println(stringBuilder.toString());
        
    }
}