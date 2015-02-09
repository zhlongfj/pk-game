/**
 * Created by zhl on 15/2/9.
 */
public class Player {
    private int vitality;
    private String name;

    public Player(String name, int i) {
        this.name = name;
    }

    public void attack(Player play) {
        play.reduceVitality(12);
    }

    public void reduceVitality(int attackedVitiality) {
        vitality -= attackedVitiality;
    }

    public int getVitality() {
        return vitality;
    }
}
