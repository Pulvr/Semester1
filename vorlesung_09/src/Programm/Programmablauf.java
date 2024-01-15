package Programm;

import Pokemon.Pokemon;
import Pokemon.Feuer.Glumanda;
import Pokemon.Pflanze.Bisaknosp;
import Pokemon.Wasser.Shiggy;

//Aufgabe 9 Inventar : Florian Wendel - florian.wendel@haw-hamburg.de

public class Programmablauf {
	public static void main(String[] args) {

		// alle nötigen Objekte werden erzeugt.
		Pokemon p1 = new Glumanda();
		Pokemon p2 = new Shiggy();

		Trainer t1 = new Trainer("Ash");
		Trainer t2 = new Trainer("Rocket");
		
		// Pokemon den Trainern zuordnen
		t1.catchPokemon(p1);
		t2.catchPokemon(p2);
		t1.catchPokemon(new Bisaknosp());
		t2.catchPokemon(new Shiggy());
		
		//Sample Code um das Inventar zu testen
		// t1.inventory = new HealthPotion(1, t1);
		System.out.println(t1.inventory.toString());
		t1.inventory.getItemCount();
		// t1.inventory.drop(t1.inventory.search("Pokeball"));
		System.out.println(t1.inventory.toString());
		t1.inventory.getItemCount();
		if (t1.inventory.search("Pokeball") != null) {
			System.out.println(t1.inventory.search("Pokeball").toString());
		}

		// Kampf starten
		PokeArena(t1, t2);
	}

	public static void PokeArena(Trainer t1, Trainer t2) {
		int round = 1;
		Trainer attacker = t1;
		Trainer defender = t2;

		while (t1.isReadyToFight() && t2.isReadyToFight()) {
			// Rollen wechseln
			Trainer tmp = attacker;
			attacker = defender;
			defender = tmp;

			//Healthpotions im Kampf einsetzen
			if (attacker.activePokemon != null) {
				if (attacker.activePokemon.getHealth() < attacker.activePokemon.getMaxHealth() / 2) {
					if (attacker.inventory.search("HealthPotion") != null) {
						attacker.inventory.use(attacker.inventory.search("HealthPotion"), attacker.activePokemon);
					}
				}
			}
			System.out.println("\n" + round++ + ". Runde");
			attacker.fight(defender);
		}

		System.out.println("\n### Kampf beendet. " + attacker.name + " hat " + defender.name + " besiegt.");
	}
}
