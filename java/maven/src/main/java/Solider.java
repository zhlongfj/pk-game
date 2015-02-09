import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Solider extends Player {
    public Solider(String name, int vitality, Weapon weapon, Armor armor, Random random) {
        super("战士" + name, vitality, random);
    }

    public void attack(Player play) {
        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitality) {
        this.attackedVitality = attackedVitality;
        vitality -= this.attackedVitality;
    }
}
