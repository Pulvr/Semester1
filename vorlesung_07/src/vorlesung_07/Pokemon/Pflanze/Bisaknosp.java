package vorlesung_07.Pokemon.Pflanze;

public class Bisaknosp extends Bisasam {

    public Bisaknosp(String name, Type type, int maxHealth) {
        super(name, type, maxHealth);
        this.addAttack(rasierblatt);
    }
    
}