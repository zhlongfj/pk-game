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

    private Random randomZhangsan;
    private Random randomLisi;
    private PrintStream out;

    @Before
    public void setUp() throws Exception {
        randomZhangsan = mock(Random.class);
        randomLisi = mock(Random.class);
        out = mock(PrintStream.class);

    }

    @Test
    public void should_print_who_is_defeated_when_game_over() {
        given(randomZhangsan.nextInt(10))
                .willReturn(8, 8, 6);
        given(randomLisi.nextInt(10))
                .willReturn(2, 2, 3);

        Player zhangsan = new Player("张三", 10, randomZhangsan);
        Player lisi = new Player("李四", 20, randomLisi);
        GameProcess game = new GameProcess(out, zhangsan, lisi);
        game.play();

        verify(out).println("李四被打败了");
    }


}
