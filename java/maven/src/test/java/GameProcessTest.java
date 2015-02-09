import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcessTest {

    private Random random1;
    private Random random2;
    private PrintStream out;

    @Before
    public void setUp() throws Exception {
        random1 = mock(Random.class);
        random2 = mock(Random.class);
        out = mock(PrintStream.class);

    }

    @Test
    public void should_print_who_is_defeated_when_game_over() {
        given(random1.nextInt(10))
                .willReturn(8, 8, 6);
        given(random2.nextInt(10))
                .willReturn(2, 2, 3);

        Player playerFirstAttack = new OrdinaryPlayer("张三", 10, random1);
        Player playerSecondAttack = new OrdinaryPlayer("李四", 20, random2);
        GameProcess game = new GameProcess(out, playerFirstAttack, playerSecondAttack);
        game.start();

        verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_pk_process() {
        given(random1.nextInt(10))
                .willReturn(8, 8);
        given(random2.nextInt(10))
                .willReturn(9, 9);

        Player playerFIrstAttack = new OrdinaryPlayer("张三", 10, random1);
        Player playerSecondAttack = new OrdinaryPlayer("李四", 20, random2);
        GameProcess game = new GameProcess(out, playerFIrstAttack, playerSecondAttack);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命：12");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,张三受到了9点伤害,张三剩余生命：1");
        inOrder.verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命：4");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,张三受到了9点伤害,张三剩余生命：-8");
        inOrder.verify(out).println("张三被打败了");
    }

    @Test
    public void should_improve_value_of_attack_when_solider_use_weapon() {
        given(random1.nextInt(10))
                .willReturn(4, 8);
        given(random2.nextInt(10))
                .willReturn(9, 9);

        Player solider = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random1);
        Player ordinaryPlayer = new OrdinaryPlayer("李四", 20, random2);
        GameProcess game = new GameProcess(out, solider, ordinaryPlayer);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("战士张三用优质木棒攻击了普通人李四,李四受到了8点伤害,李四剩余生命：12");
    }

    @Test
    public void should_reduce_value_of_attacked_when_solider_is_attacked() {
        given(random1.nextInt(10))
                .willReturn(4);
        given(random2.nextInt(10))
                .willReturn(7);

        Player solider = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random1);
        Player ordinaryPlayer = new OrdinaryPlayer("李四", 20, random2);
        GameProcess game = new GameProcess(out, ordinaryPlayer, solider);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("普通人李四攻击了战士张三,张三受到了3点伤害,张三剩余生命：7");
    }

    @Test
    public void should_value_of_attacked_is_zero_when_value_of_attacked_is_less_than_value_of_defence() {
        given(random1.nextInt(10))
                .willReturn(4);
        given(random2.nextInt(10))
                .willReturn(2);

        Player solider = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random1);
        Player ordinaryPlayer = new OrdinaryPlayer("李四", 20, random2);
        GameProcess game = new GameProcess(out, ordinaryPlayer, solider);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("普通人李四攻击了战士张三,张三受到了0点伤害,张三剩余生命：10");
    }

    @Test
    public void should_print_right_info_when_ordinary_player_attack_ordinary_player() {
        given(random1.nextInt(10))
                .willReturn(8);
        given(random2.nextInt(10))
                .willReturn(2);

        Player player1 = new OrdinaryPlayer("张三", 10, random1);
        Player player2 = new OrdinaryPlayer("李四", 12, random2);

        GameProcess game = new GameProcess(out, player1, player2);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命：4");
    }

    @Test
    public void should_print_right_info_when_solider_attack_solider() {
        given(random1.nextInt(10))
                .willReturn(8);
        given(random2.nextInt(10))
                .willReturn(5);

        Player player1 = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random1);
        Player player2 = new Solider("李四", 20, new Weapon("优质木棒", 3), new Armor("铠甲", 3), random1);

        GameProcess game = new GameProcess(out, player1, player2);
        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("战士张三用优质木棒攻击了战士李四,李四受到了9点伤害,李四剩余生命：11");
    }
}
