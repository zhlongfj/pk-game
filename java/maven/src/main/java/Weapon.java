/**
 * Created by zhl on 15/2/9.
 */
public class Weapon {

    private String name;
    private int valueOfAttack;

    public Weapon(String name, int valueOfAttack) {
        this.name = name;
        this.valueOfAttack = valueOfAttack;
    }

    public String getName() {
        return name;
    }

    public int getValueOfAttack() {
        return valueOfAttack;
    }
}
