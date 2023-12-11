package vorlesung_07.Pokemon;

import java.util.List;
import java.util.ArrayList;

public class Trainer {
    public String name;
    private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
    public Pokemon activePokemon;

    // Konstruktor
    Trainer(String name) {
        this.name = name;
    }

    // Methode zum Fangen der Pokemon, es wird das zu fangende mon und der Trainer
    // übergeben
    // dem das mon zugehörig ist. Zuerst prüfen, ob dem mon nicht schon ein trainer
    // zugeordnet ist
    // dem pokemon wird der trainer zugewiesen
    public void catchPokemon(Pokemon poke) {
        if (poke.getTrainer() == null) {
            myPokemon.add(poke);
            poke.trainer = this;
            System.out.println(poke.getName() + " wurde gefangen!");
        }
    }

    // counter ausserhalb des for loops definiert, damit der name des gewählten
    // pokemon ausgegeben wird
    void callPokemon() {
        int counter = 0;
        for (; counter < myPokemon.size(); counter++) {
            if (myPokemon.get(counter).getHealth() > 0) {
                activePokemon = myPokemon.get(counter);
                break;
            }
        }
        counter = 0;
        System.out.println("Du bist dran: " + myPokemon.get(counter).getName());
    }

    public String getName() {
        return this.name;
    }
}
