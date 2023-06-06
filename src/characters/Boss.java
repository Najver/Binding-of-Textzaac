package characters;

public class Boss extends Entity{
    private String name;
    private int maxHp;
    private int damage;

    public Boss(String name, int maxHp, int damage) {
        super(name, maxHp,damage);
    }
}
