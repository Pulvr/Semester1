package vorlesung_07.Pokemon.Pflanze;

//Aufgabe 8 Pokemon : Florian Wendel - florian.wendel@haw-hamburg.de

public class Bisaknosp extends Bisasam {

    public Bisaknosp(String name, Type type, int maxHealth) {
        super(name, type, maxHealth);
        this.addAttack(rasierblatt);
    }
    
}