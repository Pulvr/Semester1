package vorlesung_07.Pokemon.Wasser;

//Aufgabe 8 Pokemon : Florian Wendel - florian.wendel@haw-hamburg.de

import vorlesung_07.Pokemon.Pokemon;

public class Schiggy extends Pokemon {

    public Schiggy(String name, Type type, int maxHealth) {
        super(name, type, maxHealth);
        this.addAttack(aquaknarre);
    }

    // protected void takeDamage(int damage) {
    // damage = Math.abs(damage); // damage soll nur positiv sein, also den Betrag
    // nehmen
    // int currentHealth = this.getHealth(); // in variable zwischenspeichern, da
    // kein direkter access möglich ist
    // currentHealth -= damage - 1; // damage nehmen und einen abziehen, also statt
    // 15 bspw.14
    // if (currentHealth < 0) currentHealth = 0;
    // setHealth(currentHealth); // über setter HP setzen
    // }

    // einfacherere Version, man muss nicht alles abschreiben sondern kann einfach
    // "super.takedamage" verwenden
    public void takeDamage(int dmg) {
        super.takeDamage(dmg - 1);
    }
}
