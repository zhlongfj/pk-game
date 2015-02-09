import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class OrdinaryPlayer extends Player{
    public OrdinaryPlayer(String name, int vitality, Random random) {
        super(name, vitality, random);
        profession = "普通人";
    }

    public void attack(Player play) {
        if (this.getVitality() <= 0)
            return;

        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitality) {
        this.attackedVitality = attackedVitality;
        vitality -= this.attackedVitality;
    }

    public String getUsedWeapon() {
        return "";
    }

}
