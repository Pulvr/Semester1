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
        else{
            System.out.println("Pokemon wurde nicht gefangen");
        }
    }

    // counter ausserhalb des for loops definiert, damit der name des gewählten
    // pokemon ausgegeben wird
    // return, damit die Methode direkt beendet wird, sobald eins gefundne wird. 
    void callPokemon() {
        
        for (int i = 0; i < myPokemon.size(); i++) {
            if (myPokemon.get(i).getHealth() > 0) {
                activePokemon = myPokemon.get(i);
                System.out.println("Du bist dran: " + myPokemon.get(i).getName());
                return;
            }
        }
        activePokemon = null;
        System.out.println(name+" hat keien kampffähigen Pokemon mehr");
    }

    public String getName() {
        return this.name;
    }
}
