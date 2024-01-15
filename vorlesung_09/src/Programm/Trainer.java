package Programm;

import java.util.ArrayList;
import java.util.List;

import Item.HealthPotion;
import Item.Inventory;
import Item.Pokeball;
import Pokemon.Pokemon;

//Aufgabe 9 Inventar : Florian Wendel - florian.wendel@haw-hamburg.de

public class Trainer 
{

	//Attribute
	public String name;
	private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
	public Pokemon activePokemon;
	public Inventory inventory = new Inventory(this);
	
	//Konstruktor
	public Trainer(String name)
	{
		this.name = name;
		this.inventory.add(new Pokeball(1,this));
		this.inventory.add(new HealthPotion(1, this));
		this.inventory.add(new Pokeball(2, this));
	}
	
	//Methoden
	public void catchPokemon(Pokemon poke)
	{
		if (poke.myTrainer == null && this.inventory.search("Pokeball")!= null)
		{
			poke.myTrainer = this;
			myPokemon.add(poke);
			inventory.use(inventory.search("Pokeball"),poke);
			System.out.println(name + " fängt " + poke + "!");
		}
		else if (poke.myTrainer != null )
		{
			System.out.println(poke + " kann von " + name + " nicht gefangen werden, es gehört schon zu " + poke.myTrainer);
		}
		else if (this.inventory.search("Pokball") == null ) 
		{
			System.out.println("Es ist kein Pokeball mehr vorhanden");
		}
	}
	
	private void callPokemon()
	{
		if (myPokemon == null)
		{
			System.out.println("Kein Pokemon zum Rufen.");
			return;
		}
		
		if (activePokemon != null && activePokemon.getHealth() > 0)
		{
			return;
		}
		
		for (Pokemon p: myPokemon)
		{
			if (p.getHealth() > 0)
			{
				activePokemon = p;
				System.out.println(name + ": " + p + " ich rufe dich!");
				p.speak();
				return;
			}
		}
	}
	
	public void fight(Trainer enemy)
	{
		if (this.isReadyToFight() && enemy.isReadyToFight())
		{
			callPokemon();
			enemy.callPokemon();
			
			activePokemon.fight(enemy.activePokemon);			
		}
	}
	
	public boolean isReadyToFight()
	{
		boolean ready = false;
		
		if (myPokemon != null)
		{
			for (Pokemon p: myPokemon)
			{
				if (p.getHealth() > 0) ready = true;
			}
		}
		
		return ready;
	}
}
