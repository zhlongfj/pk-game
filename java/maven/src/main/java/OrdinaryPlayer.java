import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class OrdinaryPlayer extends Player{
    public OrdinaryPlayer(String name, int vitality, Random random) {
        super("普通人" + name, vitality, random);
    }

    public void attack(Player play) {
        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitality) {
        this.attackedVitality = attackedVitality;
        vitality -= this.attackedVitality;
    }
}
