package vorlesung_07.Pokemon;

public class Pokemon {
    enum Type {
        FEUER, WASSER, PFLANZE
    }

    private String name;
    private int lvl;
    private int exp;
    public Type type;
    private int health;
    private int maxHealth;
    private int attackDamage;

    Pokemon(String name, int lvl, int exp, Type type, int health, int maxHealth, int attackDamage) {
        this.name = name;
        this.lvl = lvl;
        this.exp = exp;
        this.type = type;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
    }

    public void doDamage(Pokemon any) {
        any.attackDamage -= any.health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void addHealth(int amount) {
        this.health += amount;
    }

    protected void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // noch ausbaufähig
    public String toString() {
        return "Name: " + this.name + "\nLevel: " + this.lvl + "\nHealth: " + this.health;
    }

}
