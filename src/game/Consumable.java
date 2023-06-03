package game;

public class Consumable extends Item{

    private int returnHp;
    private int returnMana;

    public int getReturnHp() {
        return returnHp;
    }

    public void setReturnHp(int returnHp) {
        this.returnHp = returnHp;
    }

    public int getReturnMana() {
        return returnMana;
    }

    public void setReturnMana(int returnMana) {
        this.returnMana = returnMana;
    }

    public Consumable(String name, int returnHp, int returnMana) {
        super(name);
        this.returnHp = returnHp;
        this.returnMana = returnMana;
    }

    @Override
    public String toString() {
        return name + ": addHp:" + returnHp + ", addMana:" + returnMana;
    }
}
