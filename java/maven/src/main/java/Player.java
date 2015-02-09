import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Player {
    private int vitality;
    private String name;
    private Random random;

    public Player(String name, int i, Random random) {
        this.name = name;
        this.random = random;
    }

    public void attack(Player play) {
        play.reduceVitality(random.nextInt(10));
    }

    public void reduceVitality(int attackedVitiality) {
        vitality -= attackedVitiality;
    }

    public int getVitality() {
        return vitality;
    }
}
