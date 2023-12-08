package vorlesung_07.Pokemon;

public class Pokemon {
    public enum Type {
        FEUER, WASSER, PFLANZE
    }

    private String name;
    private int lvl;
    private int exp;
    public Type type;
    private int health;
    private int maxHealth;
    private int attackDamage;

    //Konstruktor, Werte wie lvl und exp sind vorab gesetzt. 
    public Pokemon(String name, Type type, int maxHealth, int attackDamage) {
        this.name = name;
        this.lvl = 1;
        this.exp = 0;
        this.type = type;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackDamage = attackDamage;
    }

    //Methode um anderen Pokemon schaden hinzuzufügen, dafür wird ein Pokemon "other" übergeben
    //das "other" Pokemon ruft für sich die Methode takeDamage auf und nimmt "attackDamage" des Angreifers
    public void doDamage(Pokemon other) {
        System.out.println(this.name + " hat "+ other.name + "angegriffen");
        other.takeDamage(this.attackDamage);
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void addHealth(int amount) {
        if (amount > 0){         //prüfen ob Gesundheit added mehr als 0 ist, erst dann hinzufü
            this.health += amount;
            if (this.health >= maxHealth) this.health = maxHealth;      //Gesundheit kann nicht mehr sein als maxHealth
            System.out.println(this.name + " wurde um "+ amount + " geheilt");
        }
        
    }
    
    
    protected void takeDamage(int damage) {
        damage = Math.abs(damage);                  //damage soll nur positiv sein, also den Betrag nehmen
        this.health -= damage;      
        if (this.health < 0) this.health = 0;       //Health kann nicht weniger als 0 sein
        System.out.println(this.name + " hat  "+ damage + " Punkte Schaden genommen ");
    }

    // noch ausbaufähig
    public String toString() {
        return "Name: " + this.name + "\nLevel: " + this.lvl + "\nHealth: " + this.health+"/"+this.maxHealth;
    }
    
}
