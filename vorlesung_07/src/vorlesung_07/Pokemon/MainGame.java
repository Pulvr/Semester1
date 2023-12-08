package vorlesung_07.Pokemon;
import vorlesung_07.Pokemon.Pokemon.Type;

public class MainGame {
    
    
    public static void main(String[] args) {
        Pokemon bisa = new Pokemon("Bisasam", Type.PFLANZE, 100);
        Pokemon gluma = new Pokemon("Glumanda", Type.FEUER, 100);

        // System.out.println(poke.getName());
        System.out.println(bisa.getState());
        System.out.println(gluma.getState());
        
        System.out.println(bisa.toString());
        System.out.println(gluma.toString());
        

        bisa.doDamage(gluma);
        //System.out.println(bisa.attacks.get(0).toString());

        System.out.println(bisa.getState());
        System.out.println(gluma.getState());
    }
}
