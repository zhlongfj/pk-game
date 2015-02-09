import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcessTest {

    private Random randomFirstAttack;
    private Random randomSecondAttack;
    private PrintStream out;

    @Before
    public void setUp() throws Exception {
        randomFirstAttack = mock(Random.class);
        randomSecondAttack = mock(Random.class);
        out = mock(PrintStream.class);

    }

    @Test
    public void should_print_who_is_defeated_when_game_over() {
        given(randomFirstAttack.nextInt(10))
                .willReturn(8, 8, 6);
        given(randomSecondAttack.nextInt(10))
                .willReturn(2, 2, 3);

        Player playerFirstAttack = new OrdinaryPlayer("张三", 10, randomFirstAttack);
        Player playerSecondAttack = new OrdinaryPlayer("李四", 20, randomSecondAttack);
        GameProcess game = new GameProcess(out, playerFirstAttack, playerSecondAttack);
        game.play();

        verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_pk_process() {
        given(randomFirstAttack.nextInt(10))
                .willReturn(8, 8);
        given(randomSecondAttack.nextInt(10))
                .willReturn(9, 9);

        Player playerFIrstAttack = new OrdinaryPlayer("张三", 10, randomFirstAttack);
        Player playerSecondAttack = new OrdinaryPlayer("李四", 20, randomSecondAttack);
        GameProcess game = new GameProcess(out, playerFIrstAttack, playerSecondAttack);
        game.play();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命：12");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,张三受到了9点伤害,张三剩余生命：1");
        inOrder.verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命：4");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,张三受到了9点伤害,张三剩余生命：-8");
        inOrder.verify(out).println("张三被打败了");
    }

}
