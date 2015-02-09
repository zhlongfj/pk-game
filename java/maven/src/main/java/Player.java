import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Player {
    private int vitality;
    private String name;
    private Random random;

    public int getAttackedVitiality() {
        return attackedVitiality;
    }

    private int attackedVitiality;

    public Player(String name, int vitality, Random random) {
        this.name = name;
        this.vitality = vitality;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public void attack(Player play) {
        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitiality) {
        this.attackedVitiality = attackedVitiality;
        vitality -= this.attackedVitiality;
    }

    public int getVitality() {
        return vitality;
    }
}
