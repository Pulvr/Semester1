package vorlesung_07.Pokemon.Wasser;

import vorlesung_07.Pokemon.Pokemon;

public class Schiggy extends Pokemon{

    public Schiggy(String name, Type type, int maxHealth) {
        super(name, type, maxHealth);
        this.addAttack(aquaknarre);
    }
    
}
