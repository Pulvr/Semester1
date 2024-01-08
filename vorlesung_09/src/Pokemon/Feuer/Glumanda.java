package Pokemon.Feuer;

import Pokemon.Pokemon;

public class Glumanda extends Pokemon{

	// Konstruktoren
	protected Glumanda(String name) {
		super(name, Type.FEUER);
		addAttack(new Attack("Glut", 20, Type.FEUER));
	}
	
	public Glumanda()
	{
		this("Glumanda");
	}
}
