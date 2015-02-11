import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcess {
    private PrintStream out;
    private Player firstAttackPlayer;
    private Player secondAttackPlayer;

    public static void main(String[] args) {
        Player player1 = new OrdinaryPlayer("张三", 10, new Random());
        Player player2 = new Solider("李四", 20, new Weapon("优质木棒", 4), new Armor("铠甲", 4), new Random());
        GameProcess game = new GameProcess(System.out, player1, player2);
        game.start();
    }

    public GameProcess(PrintStream out, Player firstAttackPlayer, Player secondAttackPlayer) {
        this.out = out;
        this.firstAttackPlayer = firstAttackPlayer;
        this.secondAttackPlayer = secondAttackPlayer;
    }

    public void start() {
        fight();
        fightResult();
    }

    private void fight() {
        while (firstAttackPlayer.getVitality() > 0 && secondAttackPlayer.getVitality() > 0) {
            fightOnce();
        }
    }

    private void fightResult() {
        if (firstAttackPlayer.getVitality() <= 0) {
            out.println(firstAttackPlayer.getProfession() + firstAttackPlayer.getName() + "被打败了");
        }

        if (secondAttackPlayer.getVitality() <= 0){
            out.println(secondAttackPlayer.getProfession() + secondAttackPlayer.getName() + "被打败了");
        }
    }

    private void fightOnce() {
        firstAttackPlayer.attack(secondAttackPlayer);
        printAttack(firstAttackPlayer, secondAttackPlayer);
        secondAttackPlayer.attack(firstAttackPlayer);
        printAttack(secondAttackPlayer, firstAttackPlayer);
    }

    private void printAttack(Player attackPlayer, Player attackPlayer) {
        out.println(attackPlayer.getProfession() + attackPlayer.getName() + attackPlayer.getUsedWeapon()
                + "攻击了" + attackPlayer.getProfession() + attackPlayer.getName() + ","
                + attackPlayer.getName() + "受到了" + attackPlayer.getAttackedVitality() + "点伤害,"
                + attackPlayer.getName() + "剩余生命：" + attackPlayer.getVitality());
    }
}
