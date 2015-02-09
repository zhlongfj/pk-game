import java.io.PrintStream;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcess {
    private PrintStream out;
    private Player playerFirstAttack;
    private Player playerSecondAttack;

    public GameProcess(PrintStream out, Player playerFirstAttack, Player playerSecondAttack) {
        this.out = out;
        this.playerFirstAttack = playerFirstAttack;
        this.playerSecondAttack = playerSecondAttack;
    }

    public void play() {
        while (playerFirstAttack.getVitality() > 0 && playerSecondAttack.getVitality() > 0) {
            playerFirstAttack.attack(playerSecondAttack);
            playerSecondAttack.attack(playerFirstAttack);
        }

        if (playerFirstAttack.getVitality() <= 0) {
            out.println("被打败了");
        }

        if (playerSecondAttack.getVitality() <= 0){
            out.println("李四被打败了");
        }

    }
}
