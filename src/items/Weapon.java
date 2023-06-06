package items;

public class Weapon extends Item{

    private int ad;

    private int ap;

    private int bonusMana;

    private int bonusHp;

    public Weapon(String name, int ad, int ap, int bonusMana, int bonusHp) {
        super(name);
        this.ad = ad;
        this.ap = ap;
        this.bonusMana = bonusMana;
        this.bonusHp = bonusHp;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }

    public int getBonusHp() {
        return bonusHp;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    @Override
    public String toString() {
        return name +": ad:" + ad + ", ap:" + ap + ", bonusMana:" + bonusMana + ", bonusHp:" + bonusHp;
    }
}
