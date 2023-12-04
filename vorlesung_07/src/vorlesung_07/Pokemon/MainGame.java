package vorlesung_07.Pokemon;
import vorlesung_07.Pokemon.Pokemon.Type;

public class MainGame {
    
    
    public static void main(String[] args) {
        Pokemon poke = new Pokemon("Bisasam", 12, 34, Type.PFLANZE, 40, 240, 30 );
        
        System.out.println(poke.getName());
        System.out.println(poke.getHealth());
        
        System.out.println(poke.toString());
    }
}
