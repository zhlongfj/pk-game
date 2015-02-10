import java.io.PrintStream;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcess {
    private PrintStream out;
    private Player firstAttackPlayer;
    private Player secondAttackPlayer;

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

    private void printAttack(Player attackPlayer, Player attackedPalyer) {
        out.println(attackPlayer.getProfession() + attackPlayer.getName() + attackPlayer.getUsedWeapon()
                + "攻击了" + attackedPalyer.getProfession() + attackedPalyer.getName() + ","
                + attackedPalyer.getName() + "受到了" + attackedPalyer.getAttackedVitality() + "点伤害,"
                + attackedPalyer.getName() + "剩余生命：" + attackedPalyer.getVitality());
    }
}
