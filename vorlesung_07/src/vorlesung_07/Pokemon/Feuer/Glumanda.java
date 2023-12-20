package vorlesung_07.Pokemon.Feuer;

//Aufgabe 8 Pokemon : Florian Wendel - florian.wendel@haw-hamburg.de

import vorlesung_07.Pokemon.Pokemon;

public class Glumanda extends Pokemon{
    
    public Glumanda(String name, Type type, int maxHealth){
        
        super(name, type, maxHealth);
        this.addAttack(glut);
        
    }
        
}
