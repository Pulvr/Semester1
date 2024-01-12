package Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Programm.Trainer;

public class Pokemon {
	//=== ATTRIBUTE ===
	public enum Type { NORMAL, FEUER, WASSER, PFLANZE }
	private String name;
	private int lvl;
	private int exp;
	public Type type;
	private int health;
	private int maxHealth;
	public Trainer myTrainer;
	private List<Attack> attacks = new ArrayList<Attack>();
	
	//=== KONSTRUKTOR ===
	protected Pokemon(String name, Type type)
	{
		this.name = name;
		setLevel(1);
		this.exp = 1;
		this.type = type;
		attacks.add(new Attack("Tackle", 10, Type.NORMAL));
	}
	
	
	//=== METHODEN ===
	
	// Level Methoden
	protected void setLevel(int newlvl)
	{
		this.lvl = Math.abs(newlvl);
		this.maxHealth = 75 + (newlvl * 25);
		this.health = maxHealth;
	}
	
	public int getLevel()
	{
		return this.lvl;
	}
	
	private void checkLevelUp()
	{
		if (exp > lvl)
		{
			exp = 0;
			setLevel(getLevel()+1);
			System.out.println(this + " ist eine Level aufgestiegen!");
		}
	}	
	
	
	// Exp Methoden
	public int getExp()
	{
		return this.exp;
	}
	
	public void addExp()
	{
		this.exp++;
		System.out.println(this + " hat Erfahrung bekommen.");
		checkLevelUp();
	}
	
	
	// Attack Methoden
	public List<Attack> getAttacks()
	{
		return this.attacks;
	}
	
	protected void addAttack(Attack atk)
	{
		attacks.add(atk);
	}
	
	
	// Health Methoden	
	public int getHealth()
	{
		return health;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void addHealth(int amount)
	{
		health += Math.abs(amount);
		health = Math.min(maxHealth, health); //health soll maxhealth nie übersteigen
	}
	
	public void takeDamage(int dmg)
	{
		health -= Math.abs(dmg);
		System.out.println(name + " nimmt " + dmg + " Schaden!");
		health = Math.max(0, health); // Minimum soll 0 sein
		if (health == 0)
		{
			System.out.println(name + " wurde besiegt!");
		}
	}
	
	
	// Andere Methoden
	public String toString()
	{
		return name + "(" + lvl + ", " +health+"/"+maxHealth+"hp)";
	}	
	
	public void fight(Pokemon other)
	{
		// optional, check ob Pokemon kämpfen können
		if (this.health > 0 && other.health > 0)
		{
			// Zufällige Attack auswählen
			Random rd = new Random();
			Attack atk = attacks.get(rd.nextInt(attacks.size()));	
			System.out.println(this + " greift " + other + " mit " + atk + " an.");
			other.takeDamage(atk.calcDamage(other));
			
			
			// prüfen ob der Gegner schon besiegt wurde.
			if (other.getHealth() <= 0)
			{
				addExp();
			}
		}		
	}
	
	//=== INNER CLASS ===
	public class Attack
	{
		protected String name;
		protected int damage;
		protected Type type;
		protected List<Type> effective = new ArrayList<Type>();
		protected List<Type> resistant = new ArrayList<Type>();
		
		
		public Attack(String name, int damage, Type type)
		{
			this.name = name;
			this.damage = damage;
			this.type = type;
		}

		public int calcDamage(Pokemon other){
			int calcDamage = damage;
			
			if (effective.contains(other.type)){
				calcDamage *=2;
				System.out.println(name + " ist sehr effektiv!");
			}else if (resistant.contains(other.type)){
				calcDamage /=2;
				System.out.println(name + " ist nicht sehr effektiv!");
			}
			
			return calcDamage;
		}
		
		public String toString()
		{
			return name + "(" + damage + " " + type +")";
		}
		
	}

	public class Attack_Plant extends Attack 
	{
		
		public Attack_Plant(String name, int dmg)
		{
			super(name,dmg,Type.PFLANZE);
			effective = Arrays.asList(Type.WASSER);
			resistant = Arrays.asList(Type.FEUER, Type.PFLANZE);
		}
	}

	public class Attack_Fire extends Attack 
	{
		
		public Attack_Fire(String name, int dmg)
		{
			super(name,dmg,Type.FEUER);
			effective = Arrays.asList(Type.PFLANZE);
			resistant = Arrays.asList(Type.FEUER, Type.WASSER);
		}
	}

	public class Attack_Water extends Attack 
	{
		
		public Attack_Water(String name, int dmg)
		{
			super(name,dmg,Type.WASSER);
			effective = Arrays.asList(Type.FEUER);
			resistant = Arrays.asList(Type.WASSER, Type.PFLANZE);
		}
	}

}
