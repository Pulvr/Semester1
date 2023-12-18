package vorlesung_07.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    public enum Type {
        FEUER, WASSER, PFLANZE, NORMAL
    }

    private String name;
    private int lvl;
    private int exp;
    private Type type;
    private int health;
    private int maxHealth;
    private List<Attack> attacks = new ArrayList<Attack>(); // Pokemon attacken Liste erstellt
    public Trainer trainer;

    // Attacken erstellt
    //auf protected geändert, damit Unterklassen drauf zugreifen dürfen
    Attack tackle = new Attack("Tackle", 40, Type.NORMAL);
    protected Attack glut = new Attack("Glut", 15, Type.FEUER);
    protected Attack aquaknarre = new Attack("Aquaknarre", 15, Type.WASSER);
    protected Attack rankenhieb = new Attack("Rankenhieb", 15, Type.PFLANZE);
    protected Attack rasierblatt = new Attack("Rasierblatt", 20, Type.PFLANZE);

    // Konstruktor, Werte wie lvl und exp sind vorab gesetzt.
    protected Pokemon(String name, Type type, int maxHealth) {
        this.name = name;
        this.lvl = 1;
        this.exp = 0;
        this.type = type;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.trainer = null;

        // fürs erste hat jedes Pokemon Tackle
        // attacken adding funktioniert jetzt im Konstruktor der jeweiligen unterKlasse
        attacks.add(tackle);

    }

    public void doDamage(Pokemon other) {
        int random = (int) (Math.random() * attacks.size()); // zufällige attacke wählen
        Attack atk = this.attacks.get(random);
        other.takeDamage(atk.damage); // nimm schaden in höhe des damage der gewählten attacke
        System.out.println(trainer.getName() + "'s " + this.name + " hat " + other.name + " mit "
                + this.attacks.get(random).name + " angegriffen");
        System.out.println(other.name + " hat " + atk.damage + " Punkte Schaden genommen\n");
    }

    public void addHealth(int amount) {
        if (amount > 0) { // prüfen ob Gesundheit added mehr als 0 ist, erst dann hinzufü
            this.health += amount;
            if (this.health >= maxHealth)
                this.health = maxHealth; // Gesundheit kann nicht mehr sein als maxHealth
            System.out.println(this.name + " wurde um " + amount + " geheilt");
        }

    }

    void takeDamage(int damage) {
        damage = Math.abs(damage); // damage soll nur positiv sein, also den Betrag nehmen
        this.health -= damage;
        if (this.health < 0)
            this.health = 0; // Health kann nicht weniger als 0 sein
    }

    public String toString() {
        return "Name: " + this.name + "\nLevel: " + this.lvl + "\nHealth: " + this.health + "/" + this.maxHealth
                + "\nEXP:" + this.exp + "\n";
    }

    // Getter und Setter
    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.lvl;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public int getHealth() {
        return this.health;
    }

    public int getExp() {
        return this.exp;
    }

    public List<Attack> getAttacks() {
        return this.attacks;
    }

    public Type getType(){
        return this.type;
    }

    // eigene Methode die getname und getHealth zusammenfasst
    public String getState() {
        return this.getName() + " hat " + this.getHealth() + " Gesundheit\n";
    }

    public void setLevel(int lvl) {
        this.lvl = lvl;
    }

    public void addExp(int value) {
        if (value > 0) {
            this.exp += value;
        } else {
            System.err.println("XP muss groesser als 0 sein!");
        }
    }

    public void addAttack(Attack atk){
        this.getAttacks().add(atk);
    }

    private void checkLevelUp(){
        if (this.getExp()>=100){
            this.exp = 0;
            this.lvl += 1;
            System.out.println("Glueckwunsch!,  "+this.getName()+" ist jetzt Level: "+this.getLevel());
        }else{
            System.out.println(this.getName()+" benötigt noch "+(100 - this.exp)+" XP zum LevelUP");
        }
    }

    // innere Klasse zum darstellen des Angriffs
    class Attack {
        private String name;
        private int damage;
        private Type type;

        Attack(String name, int damage, Type type) {
            this.name = name;
            this.damage = damage;
            this.type = type;
        }

        public String toString() {
            return this.name + " ( " + this.damage + " " + this.type + " )\n";
        }
    }
}
