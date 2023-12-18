package vorlesung_07.Pokemon.Pflanze;

import vorlesung_07.Pokemon.Pokemon;

public class Bisasam extends Pokemon {

    // Konstruktor
    // super wird geschrieben um sich auf die Attribute des abgeleiteten
    // Konstruktors zu beziehen
    public Bisasam(String name, Type type, int maxHealth) {
        super(name, type, maxHealth);
        this.addAttack(rankenhieb);
    }

}
