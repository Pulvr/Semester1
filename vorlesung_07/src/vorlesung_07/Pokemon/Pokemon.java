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
    public Type type;
    private int health;
    private int maxHealth;
    public Trainer trainer;
    public List<Attack> attacks = new ArrayList<Attack>(); // Pokemon attacken Liste erstellt

    // Attacken erstellt
    Attack tackle = new Attack("Tackle", 40, Type.NORMAL);
    Attack glut = new Attack("Glut", 30, Type.FEUER);
    Attack kratzer = new Attack("Kratzer", 20, Type.NORMAL);

    // Konstruktor, Werte wie lvl und exp sind vorab gesetzt.
    public Pokemon(String name, Type type, int maxHealth) {
        this.name = name;
        this.lvl = 1;
        this.exp = 0;
        this.type = type;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.trainer = null;

        // attacken wurden hier im Konstruktor geaddet, vermutlich besser sie an einer
        // anderen Stelle zu erstellen
        // Ansonsten hat jedes Pokemon immer tackle, glut und kratzer.
        attacks.add(tackle);
        attacks.add(glut);
        attacks.add(kratzer);
    }

    public void doDamage(Pokemon other) {
        int random = (int) (Math.random() * attacks.size()); // zufällige attacke wählen
        other.takeDamage(this.attacks.get(random).damage); // nimm schaden in höhe des damage der gewählten attacke
        System.out.println(this.name + " hat " + other.name + " mit " + this.attacks.get(random).name + " angegriffen");
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
        System.out.println(this.name + " hat " + damage + " Punkte Schaden genommen");
    }

    public String toString() {
        return "Name: " + this.name + "\nLevel: " + this.lvl + "\nHealth: " + this.health + "/" + this.maxHealth
                + "\nEXP:" + this.exp + "\n";
    }

    public String getName() {
        return this.name;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public int getHealth() {
        return this.health;
    }

    // eigene Methode die getname und getHealth zusammenfasst
    public String getState() {
        return this.getName() + " hat " + this.getHealth() + " Gesundheit\n";
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
