package Pokemon.Pflanze;

public class Bisaknosp extends Bisasam {
	
	// Konstruktor
	public Bisaknosp()
	{
		super("Bisaknosp");
		addAttack(new Attack("Rasierblatt", 25, Type.PFLANZE));
		setLevel(3);
	}	
	public void speak(){
		System.out.println("BISAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!");
	}
}
