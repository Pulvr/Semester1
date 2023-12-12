package vorlesung_07.Pokemon;

import vorlesung_07.Pokemon.Pokemon.Type;

public class MainGame {

    public static void main(String[] args) {
        // Pokemon erstellen
        Pokemon bisa = new Pokemon("Bisasam", Type.PFLANZE, 100);
        Pokemon gluma = new Pokemon("Glumanda", Type.FEUER, 100);
        Pokemon schig = new Pokemon("Schiggy", Type.WASSER, 100);
        Pokemon rat = new Pokemon("Rattfratz", Type.NORMAL, 100);

        // State ausgeben lassen
        System.out.println(bisa.getState());
        System.out.println(gluma.getState());

        // Trainer erstellen
        Trainer ash = new Trainer("Ash");
        Trainer garry = new Trainer("Garry");

        // Trainer auf pokemon verteilt
        ash.catchPokemon(bisa);
        ash.catchPokemon(rat);
        garry.catchPokemon(gluma);
        garry.catchPokemon(schig);

        // aktives Pokemon vorm Kampf setzen, da aktives mon sonst null
        garry.callPokemon();
        ash.callPokemon();

        // solange einer von beiden noch pokemon hat, gegeneinander kämpfen
        // Unterstrich zum visuellen trennen der Schleifenelemente voneinander
        // Ebenfalls HP ausgabe jedes aktiven mons für mehr infos
        while (ash.isReadyToFight() == true && garry.isReadyToFight()) {
            System.out.println("___________________________");
            garry.fight(ash);
            ash.fight(garry);
            System.out.println(garry.activePokemon.getName()+ " " + garry.activePokemon.getHealth());
            System.out.println(ash.activePokemon.getName()+ " "+  ash.activePokemon.getHealth()+"\n");
        }

    }
}
