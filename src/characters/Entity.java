package characters;

public class Entity {

    private String name;
    private int hp;
    private int damage;

    public Entity(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
