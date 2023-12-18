package vorlesung_07.Pokemon.Feuer;

import vorlesung_07.Pokemon.Pokemon;

public class Glumanda extends Pokemon{
    
    public Glumanda(String name, Type type, int maxHealth){
        super(name, type, maxHealth);
        this.addAttack(glut);
        
    }
        
}
