package vorlesung_07.Pokemon;

import java.util.List;
import java.util.ArrayList;

public class Trainer {
    private String name;
    private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
    private Pokemon activePokemon;

    // Konstruktor
    Trainer(String name) {
        this.name = name;
    }

    // Methode zum Fangen der Pokemon, es wird das zu fangende mon übergeben.
    // Zuerst prüfen, ob dem mon schon einen trainer hat
    // dem mon wird der trainer zugewiesen sobald gefangen
    public void catchPokemon(Pokemon poke) {
        if (poke.getTrainer() == null) {
            myPokemon.add(poke);
            poke.trainer = this;
            System.out.println(poke.getName() + " wurde von " + this.getName() + " gefangen!");
        } else {
            System.out.println(poke.getName() + " wurde von " + this.getName() + " nicht gefangen");
        }
    }


    // return, damit die Methode direkt beendet wird, sobald eins gefunden wird.
    void callPokemon() {

        for (int i = 0; i < myPokemon.size(); i++) {
            if (myPokemon.get(i).getHealth() > 0) {
                activePokemon = myPokemon.get(i);
                System.out.println("Du bist dran: " + myPokemon.get(i).getName());
                return;
            }
        }
        activePokemon = null;
        System.out.println(this.getName() + " hat keine kampffähigen Pokemon mehr");
    }

    // das aktive mon vom Trainer nehmen und dem gegener mon damage machen
    // es wird geprüft, ob eins der mons besiegt wurde um text auszugeben
    public void fight(Trainer enemy) {
        activePokemon.doDamage(enemy.activePokemon);

        if (activePokemon.getHealth() == 0) {
            System.out.println(this.getName() + "'s " + activePokemon.getName() + " wurde besiegt");
        } else if (enemy.activePokemon.getHealth() == 0) {
            System.out.println(enemy.getName() + "'s " + enemy.activePokemon.getName() + " wurde besiegt");
        }
    }

    // ähnlich wie callPokemon(), es wird über mypokemon iteriert und geprüft, ob
    // noch aktive mons vorhanden sind.
    public boolean isReadyToFight() {
        for (int i = 0; i < myPokemon.size(); i++) {
            if (myPokemon.get(i).getHealth() > 0) {
                activePokemon = myPokemon.get(i);
                return true;
            }
        }
        activePokemon = null;
        System.out.println(this.getName() + " hat keine kampffähigen Pokemon mehr");
        return false;
    }

    public String getName() {
        return this.name;
    }

    public Pokemon getActivePokemon(){
        return this.activePokemon;
    }

    public void setName(String name){
        this.name = name;
    }

}
