package vorlesung_07.Pokemon;

import vorlesung_07.Pokemon.Feuer.Glumanda;
import vorlesung_07.Pokemon.Pflanze.Bisaknosp;
import vorlesung_07.Pokemon.Pflanze.Bisasam;
import vorlesung_07.Pokemon.Pokemon.Type;
import vorlesung_07.Pokemon.Wasser.Schiggy;

public class MainGame {

    public static void main(String[] args) {
        // Pokemon erstellen
        Bisasam bisa = new Bisasam("Bisasam", Type.PFLANZE, 100);
        Glumanda gluma = new Glumanda("Glumanda", Type.FEUER, 100);
        Schiggy schig = new Schiggy("Schiggy", Type.WASSER, 100);
        Bisaknosp knosp = new Bisaknosp("Bisaknosp", Type.PFLANZE, 100);
        // Pokemon rat = new Pokemon("Rattfratz", Type.NORMAL, 100);

        // State ausgeben lassen
        System.out.println(bisa.getState());
        System.out.println(gluma.getState());

        // Trainer erstellen
        Trainer ash = new Trainer("Ash");
        Trainer garry = new Trainer("Garry");

        // Trainer auf pokemon verteilt
        ash.catchPokemon(schig);
        ash.catchPokemon(gluma);
        garry.catchPokemon(knosp);
        garry.catchPokemon(bisa);

        // aktives Pokemon vorm Kampf setzen, da aktives mon sonst null
        garry.callPokemon();
        ash.callPokemon();

        // solange einer von beiden noch pokemon hat, gegeneinander kämpfen
        // Unterstrich zum visuellen trennen der Schleifenelemente voneinander
        // Ebenfalls HP ausgabe jedes aktiven mons für mehr infos
        while (ash.getActivePokemon()!=null && garry.getActivePokemon()!=null) {
            System.out.println("___________________________");
            
            if (garry.isReadyToFight()) garry.fight(ash);
            if (ash.isReadyToFight()) ash.fight(garry);

            if (garry.getActivePokemon()!=null) System.out.println("Garry: "+garry.getActivePokemon().getName()+ " " + garry.getActivePokemon().getHealth() +"/100");
            if (ash.getActivePokemon()!=null) System.out.println("Ash: "+ash.getActivePokemon().getName()+ " "+  ash.getActivePokemon().getHealth()+"/100\n");
        }
        
        //finale Ausgabe wer gewonnen hat. 
        System.out.println("");
        if (ash.getActivePokemon() == null){
            System.out.println(ash.getName() + " wurde besiegt");
        }else{
            System.out.println(garry.getName() + " wurde besiegt");
        }

    }
}
