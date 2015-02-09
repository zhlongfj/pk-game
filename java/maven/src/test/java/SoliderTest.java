import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by zhl on 15/2/9.
 */
public class SoliderTest {

    @Test
    public void should_reduce_vitality_when_attacked() {
        Random random = mock(Random.class);
        given(random.nextInt(10)).willReturn(3);

        Player zhangsan = new Solider("张三", 10, new Weapon(), new Armor(), random);
        Player lisi = new Solider("李四", 20, new Weapon(), new Armor(), random);
        zhangsan.attack(lisi);

        assertThat(lisi.getVitality()).isLessThan(20);

    }

    @Test
    public void should_print_profession() {
        Random random = mock(Random.class);
        Player zhangsan = new Solider("张三", 10, new Weapon(), new Armor(), random);
        assertThat(zhangsan.getName()).isEqualTo("战士张三");
    }
}
