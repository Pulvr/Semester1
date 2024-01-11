package Item;

import Programm.Trainer;

public class Consumable extends Item {
    protected boolean locked = false;

    protected Consumable(String name, int count, Trainer owner) {
        super(name, count, owner);
        this.locked = false;
    }

    public boolean use() {
        if (locked == false) {
            if (super.use()) {
                locked = true;
                return true;
            }
        }
        return false;
    }
}
