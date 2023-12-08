package vorlesung_07.Pokemon;
import vorlesung_07.Pokemon.Pokemon.Type;

public class MainGame {
    
    
    public static void main(String[] args) {
        Pokemon poke = new Pokemon("Bisasam", Type.PFLANZE, 100, 30 );
        
        System.out.println(poke.getName());
        System.out.println(poke.getHealth());

        poke.addHealth(20);
        
        System.out.println(poke.toString());
    }
}
