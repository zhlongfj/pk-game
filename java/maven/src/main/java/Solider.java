import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class Solider extends Player {
    public Solider(String name, int vitality, Random random) {
        super("战士" + name, vitality, random);
    }
}
