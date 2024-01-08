package Pokemon.Wasser;

import Pokemon.Pokemon;

public class Shiggy extends Pokemon {

	// Konstruktoren
	protected Shiggy(String name) {
		super(name, Type.WASSER);
		addAttack(new Attack("Aquaknarre", 20, Type.WASSER));
	}
	
	public Shiggy()
	{
		this("Shiggy");
	}
	
	public void takeDamage(int dmg)
	{
		super.takeDamage(dmg-1);
	}
}
