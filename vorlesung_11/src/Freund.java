public class Freund {
    String name;
    
    public void sayName(){
        System.out.println(this.name);
    }
    
    Freund(String name){
        this.name = name;
        
    }
    public static void main(String[] args) {
        
        Freund[] freunde = new Freund[4];
        Freund besterFreund;
        
        freunde[0] = new Freund("Siggi");
        freunde[1] = new Freund("Peter");
        freunde[2] = new Freund("Maggie");
        freunde[3] = null;

        besterFreund = freunde[2];
        besterFreund.sayName();
        
        try {
            besterFreund = freunde[10];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Anfrage zu groß, array ist nur: "+ freunde.length + " Felder groß");
        }
        try {
            besterFreund = null;
            besterFreund.sayName();
        } catch (NullPointerException e) {
            System.out.println("BesterFreund nicht vorhanden, Null Wert ");
        }
    }
}
