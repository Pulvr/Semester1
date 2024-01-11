package Programm;

import java.util.ArrayList;
import java.util.List;

import Item.Item;
import Pokemon.Pokemon;

public class Trainer {
	//Attribute
	public String name;
	private List<Pokemon> myPokemon = new ArrayList<Pokemon>();
	public Pokemon activePokemon;
	public Item inventory;
	//Konstruktor
	public Trainer(String name)
	{
		this.name = name;
	}
	
	//Methoden
	public void catchPokemon(Pokemon poke)
	{
		if (poke.myTrainer == null)
		{
			poke.myTrainer = this;
			myPokemon.add(poke);
			System.out.println(name + " fängt " + poke + "!");
		}
		else 
		{
			System.out.println(poke + " kann von " + name + " nicht gefangen werden, es gehört schon zu " + poke.myTrainer);
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
