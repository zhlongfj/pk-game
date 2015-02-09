import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Solider extends Player {
    private Weapon weapon;
    private Armor armor;

    public Solider(String name, int vitality, Weapon weapon, Armor armor, Random random) {
        super(name, vitality, random);
        this.profession = "战士";
        this.weapon = weapon;
        this.armor = armor;
    }

    public void attack(Player play) {
        play.reduceVitality(getvalueOfAttack());
    }

    public void reduceVitality(int attackedVitality) {
        this.attackedVitality = attackedVitality - armor.getValueOfDefence();
        vitality -= this.attackedVitality;
    }

    public String getUsedWeapon() {
        return "用" + weapon.getName();
    }

    private int getvalueOfAttack() {
        return random.nextInt(10) + weapon.getValueOfAttack();
    }
}
