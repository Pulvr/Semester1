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

    public Pokemon(String name, Type type, int health, int maxHealth, int attackDamage) {
        this.name = name;
        this.lvl = 1;
        this.exp = 0;
        this.type = type;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
    }

    public void doDamage(Pokemon other) {
        System.out.println(this.name + " hat "+ other.name + "angegriffen");
        other.takeDamage(attackDamage);
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void addHealth(int amount) {
        if (amount > 0){
            this.health += amount;
            if (this.health >= maxHealth) this.health = maxHealth;
            System.out.println(this.name + " wurde um "+ amount + " geheilt");
        }
        
    }
    
    protected void takeDamage(int damage) {
        damage = Math.abs(damage);
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(this.name + " hat  "+ damage + " Punkte Schaden genommen ");
    }

    // noch ausbaufähig
    public String toString() {
        return "Name: " + this.name + "\nLevel: " + this.lvl + "\nHealth: " + this.health+"/"+this.maxHealth;
    }
    
}
