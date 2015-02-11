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

        Player zhangsan = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random);
        Player lisi = new Solider("李四", 20, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random);
        zhangsan.attack(lisi);

        assertThat(lisi.getVitality()).isLessThan(20);

    }

    @Test
    public void should_print_profession() {
        Random random = mock(Random.class);
        Player zhangsan = new Solider("张三", 10, new Weapon("优质木棒", 4), new Armor("铠甲", 4), random);

        assertThat(zhangsan.getName()).isEqualTo("张三");
        assertThat(zhangsan.getProfession()).isEqualTo("战士");
    }
}
