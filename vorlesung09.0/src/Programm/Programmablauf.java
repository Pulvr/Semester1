package Programm;

import Pokemon.Pokemon;
import Pokemon.Feuer.Glumanda;
import Pokemon.Pflanze.Bisaknosp;
import Pokemon.Wasser.Shiggy;

public class Programmablauf {
	public static void main(String[] args) {

		// alle nötigen Objekte werden erzeugt.
		Pokemon p1 = new Glumanda();
		Pokemon p2 = new Shiggy();
		
		Trainer t1 = new Trainer("Ashe");
		Trainer t2 = new Trainer("Rocket");
		
		// Pokemon den Trainern zuordnen
		t1.catchPokemon(p1);
		t2.catchPokemon(p2);		
		t1.catchPokemon(new Bisaknosp());
		t2.catchPokemon(new Shiggy());
		
		// Kampf starten		
		PokeArena(t1, t2);
	}
	
	public static void PokeArena(Trainer t1, Trainer t2)
	{
		int round = 1;
		Trainer attacker = t1;
		Trainer defender = t2;
		
		while (t1.isReadyToFight() && t2.isReadyToFight())
		{
			//Rollen wechseln
			Trainer tmp = attacker;
			attacker = defender;
			defender = tmp;
			
			System.out.println("\n" + round++ + ". Runde");
			attacker.fight(defender);			
		}
		
		System.out.println("\n### Kampf beendet. " + attacker.name + " hat " + defender.name + " besiegt.");
	}
}
