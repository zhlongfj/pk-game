import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by zhl on 15/2/9.
 */
public class OrdinaryPlayerTest {
    @Test
    public void should_reduce_vitality_when_attacked() {
        Random random = mock(Random.class);
        given(random.nextInt(10)).willReturn(3);

        Player zhangsan = new OrdinaryPlayer("张三", 10, random);
        Player lisi = new OrdinaryPlayer("李四", 20, random);
        zhangsan.attack(lisi);

        assertThat(lisi.getVitality()).isLessThan(20);

    }

    @Test
    public void should_print_profession() {
        Random random = mock(Random.class);
        Player zhangsan = new OrdinaryPlayer("张三", 10, random);

        assertThat(zhangsan.getName()).isEqualTo("张三");
        assertThat(zhangsan.getProfession()).isEqualTo("普通人");
    }
}
