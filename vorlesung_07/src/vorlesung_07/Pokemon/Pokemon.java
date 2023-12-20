package vorlesung_07.Pokemon;

import java.util.ArrayList;
import java.util.List;

//Aufgabe 8 Pokemon : Florian Wendel - florian.wendel@haw-hamburg.de

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
    // auf protected geändert, damit Unterklassen drauf zugreifen dürfen
    // Schaden wegen dem multiplier aus typechecker "halbiert" und auf int gelassen
    Attack tackle = new Attack("Tackle", 10, Type.NORMAL);
    protected Attack glut = new Attack("Glut", 7, Type.FEUER);
    protected Attack aquaknarre = new Attack("Aquaknarre", 7, Type.WASSER);
    protected Attack rankenhieb = new Attack("Rankenhieb", 7, Type.PFLANZE);
    protected Attack rasierblatt = new Attack("Rasierblatt", 10, Type.PFLANZE);

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

    protected void doDamage(Pokemon enemyPokemon) {
        int randomAtk = (int) (Math.random() * attacks.size()); // zufällige attacke wählen
        int multiplier = this.typeChecker(enemyPokemon, randomAtk); //multiplier erstellen

        Attack atk = this.attacks.get(randomAtk); //attack holen
        enemyPokemon.takeDamage(atk.damage * multiplier); // nimm schaden von atk.damage * multiplier

        System.out.println(trainer.getName() + "'s " + this.getName() + " hat " + enemyPokemon.getName() + " mit "
                + this.attacks.get(randomAtk).name + " angegriffen");

        //Extra Textausgabe wenn effektiv/nicht effektiv
        if (multiplier==4) System.out.println("Das war sehr effektiv!");
        else if (multiplier==1) System.out.println("Das war nicht sehr effektiv!");

        //Edge Case Ausgabe für Angriff auf Schiggy. Dann Ausgabe -1 weil er ja weniger damage nimmt. 
        if (enemyPokemon.getName().equals("Schiggy")) {
            System.out.println(enemyPokemon.getName() + " hat " + ((atk.damage * multiplier)-1) + " Punkte Schaden genommen\n");
        }else{
            System.out.println(enemyPokemon.getName() + " hat " + (atk.damage * multiplier) + " Punkte Schaden genommen\n");
        }
    }

    protected void takeDamage(int damage) {
        damage = Math.abs(damage); // damage soll nur positiv sein, also den Betrag nehmen
        this.health -= damage;
        if (this.health < 0)
            this.health = 0; // Health kann nicht weniger als 0 sein
    }
    

    // returned einen multiplier, wenn eine attacke stark gegen einen Typen ist
    // es wird also zuerst der attacken typ, dann der angreifer typ abgefragt
    // mit integer gemacht und multiplier by default auf 2 gestellt. Ansonsten hätte
    // überall health und damage auf float umstellen müssen für den multiplier
    public int typeChecker(Pokemon enemy, int counter) {
        int multiplier = 2;
        //effektiv
        if (this.getAttacks().get(counter).getType() == Type.WASSER && enemy.getType() == Type.FEUER) {
            multiplier = 4;
        }
        if (this.getAttacks().get(counter).getType() == Type.FEUER && enemy.getType() == Type.PFLANZE) {
            multiplier = 4;
        }
        if (this.getAttacks().get(counter).getType() == Type.PFLANZE && enemy.getType() == Type.WASSER) {
            multiplier = 4;
        }
        //nicht sehr effektiv
        if (this.getAttacks().get(counter).getType() == Type.WASSER && enemy.getType() == Type.WASSER) {
            multiplier = 1;
        }
        if (this.getAttacks().get(counter).getType() == Type.WASSER && enemy.getType() == Type.PFLANZE) {
            multiplier = 1;
        }
        if (this.getAttacks().get(counter).getType() == Type.FEUER && enemy.getType() == Type.FEUER) {
            multiplier = 1;
        }
        if (this.getAttacks().get(counter).getType() == Type.FEUER && enemy.getType() == Type.WASSER) {
            multiplier = 1;
        }
        if (this.getAttacks().get(counter).getType() == Type.PFLANZE && enemy.getType() == Type.FEUER) {
            multiplier = 1;
        }
        if (this.getAttacks().get(counter).getType() == Type.PFLANZE && enemy.getType() == Type.PFLANZE) {
            multiplier = 1;
        }
        return multiplier;
    }

    public void addHealth(int amount) {
        if (amount > 0) { // prüfen ob Gesundheit added mehr als 0 ist, erst dann adden
            this.health += amount;
            if (this.health >= maxHealth)
                this.health = maxHealth; // Gesundheit kann nicht mehr sein als maxHealth
            System.out.println(this.name + " wurde um " + amount + " geheilt");
        }

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

    public Type getType() {
        return this.type;
    }

    // eigene Methode die getname und getHealth zusammenfasst
    public String getState() {
        return this.getName() + " hat " + this.getHealth() + " Gesundheit\n";
    }

    public void setHealth(int health) {
        this.health = health;
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

    public void addAttack(Attack atk) {
        this.getAttacks().add(atk);
    }

    private void checkLevelUp() {
        if (this.getExp() >= 100) {
            this.exp = 0;
            this.lvl += 1;
            System.out.println("Glueckwunsch!,  " + this.getName() + " ist jetzt Level: " + this.getLevel());
        } else {
            System.out.println(this.getName() + " benötigt noch " + (100 - this.exp) + " XP zum LevelUP");
        }
    }

    // innere Klasse zum darstellen des Angriffs
    protected class Attack {
        private String name;
        private int damage;
        private Type type;

        Attack(String name, int damage, Type type) {
            this.name = name;
            this.damage = damage;
            this.type = type;
        }


        public Type getType() {
            return this.type;
        }


        public String toString() {
            return this.name + " ( " + this.damage + " " + this.type + " )\n";
        }
    }
}
