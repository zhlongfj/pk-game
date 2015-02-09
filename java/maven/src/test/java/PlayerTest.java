import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhl on 15/2/9.
 */
public class PlayerTest {
    @Test
    public void should_reduce_vitality_when_attacked() {
        Player zhangsan = new Player("张三", 10);
        Player lisi = new Player("李四", 20);
        zhangsan.attack(lisi);

        assertThat(lisi.getVitality()).isLessThan(20);

    }
}
