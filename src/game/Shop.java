package game;

import util.ConsumablesCSVDatabase;
import util.WeaponCSVDatabase;

import java.util.Random;

public class Shop extends Room{

    private Random random;

    public Shop(String name) {
        super(name);
        this.random = new Random();

    }

    public void openShop(){
        System.out.println("Hello i have 3 items you can buy");
        int numberOfWeapons = WeaponCSVDatabase.getWeapons().size();
        int numberOfConsumables = ConsumablesCSVDatabase.getConsumable().size();
        int numberOfSpecials = ConsumablesCSVDatabase.getSpecial().size();
        Item itemWeapon = WeaponCSVDatabase.getWeapons().get(random.nextInt(numberOfWeapons));
        Item itemConsumable = ConsumablesCSVDatabase.getConsumable().get(random.nextInt(numberOfConsumables));
        Item itemSpecial = ConsumablesCSVDatabase.getSpecial().get(random.nextInt(numberOfSpecials));
        System.out.println(itemWeapon + " " + itemConsumable + " " + itemSpecial);
    }
}
