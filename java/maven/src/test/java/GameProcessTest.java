import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Random;

import static org.mockito.BDDMockito.given;
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

        Player playerFirstAttack = new Player("张三", 10, randomFirstAttack);
        Player playerSecondAttack = new Player("李四", 20, randomSecondAttack);
        GameProcess game = new GameProcess(out, playerFirstAttack, playerSecondAttack);
        game.play();

        verify(out).println("李四被打败了");
    }


}
