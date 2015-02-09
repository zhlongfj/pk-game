import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Player {
    private int vitality;
    private String name;
    private Random random;

    private int attackedVitality;

    public Player(String name, int vitality, Random random) {
        this.name = "普通人" + name;
        this.vitality = vitality;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public int getVitality() {
        return vitality;
    }

    public int getAttackedVitality() {
        return attackedVitality;
    }

    public void attack(Player play) {
        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitality) {
        this.attackedVitality = attackedVitality;
        vitality -= this.attackedVitality;
    }
}
