package Item;

import Programm.Trainer;

public class HealthPotion extends Consumable{
    
    private int healAmount = 50;

    public HealthPotion(int count, Trainer owner) {
        super("HealthPotion", count, owner);
        
    }

    public boolean use(){
        if (super.use()){
            if (owner.activePokemon != null) {
                owner.activePokemon.addHealth(healAmount);
                return true;
            }
        }
        return false;
    }
}
