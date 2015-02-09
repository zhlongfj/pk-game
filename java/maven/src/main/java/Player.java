import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public abstract class Player {
    protected int vitality;
    protected String name;
    protected Random random;

    protected int attackedVitality;

    public Player(String name, int vitality, Random random) {
        this.name = name;
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

    public abstract void attack(Player play);

    public abstract void reduceVitality(int attackedVitality);
}
