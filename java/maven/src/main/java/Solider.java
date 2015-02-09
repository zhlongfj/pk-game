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
        play.reduceVitality(getValueOfAttack());
    }

    public void reduceVitality(int attackedVitality) {
        if (this.getVitality() <= 0)
            return;

        setAttack(attackedVitality);
        vitality -= this.attackedVitality;
    }

    public String getUsedWeapon() {
        return "用" + weapon.getName();
    }

    private int getValueOfAttack() {
        return random.nextInt(10) + weapon.getValueOfAttack();
    }

    private int calculateValueOfAttacked(int attackedVitality) {
        return attackedVitality - armor.getValueOfDefence();
    }

    private void setAttack(int attackedVitality) {
        this.attackedVitality = calculateValueOfAttacked(attackedVitality) > 0
                ? calculateValueOfAttacked(attackedVitality) : 0;
    }
}
