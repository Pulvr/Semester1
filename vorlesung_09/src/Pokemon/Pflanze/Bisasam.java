package Pokemon.Pflanze;

import Pokemon.Pokemon;

public class Bisasam extends Pokemon{

	// Konstruktoren
	protected Bisasam(String name) {
		super(name, Type.PFLANZE);
		addAttack(new Attack("Rankenhieb", 20, Type.PFLANZE));
	}
	
	public Bisasam()
	{
		this("Bisasam");
	}
}
