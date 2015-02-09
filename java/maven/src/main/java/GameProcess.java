import java.io.PrintStream;

/**
 * Created by zhl on 15/2/9.
 */
public class GameProcess {
    private PrintStream out;
    private Player zhangsan;
    private Player lisi;

    public GameProcess(PrintStream out, Player zhangsan, Player lisi) {
        this.out = out;
        this.zhangsan = zhangsan;
        this.lisi = lisi;
    }

    public void play() {
        while (zhangsan.getVitality() > 0 && lisi.getVitality() > 0) {
            lisi.attack(zhangsan);
            zhangsan.attack(lisi);
        }

        if (zhangsan.getVitality() <= 0) {
            out.println("张三被打败了");
        }

        if (lisi.getVitality() <= 0){
            out.println("李四被打败了");
        }

    }
}
