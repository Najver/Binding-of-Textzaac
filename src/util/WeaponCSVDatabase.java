package util;

import items.Weapon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeaponCSVDatabase {

    public static List<Weapon> getWeapons(){
        ArrayList<Weapon> weapons = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Weapons.csv"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] args = line.split(";");
                Weapon weapon = createWeapon(args);
                weapons.add(weapon);
            }
        }catch(IOException e){
            System.err.println("WeaponCSVDatabase error: Could not load file");
        }
        return weapons;
    }

    private static Weapon createWeapon(String[] args) {
        String name = args[0];
        int ad = Integer.parseInt(args[1]);
        int ap = Integer.parseInt(args[2]);
        int bonusMana = Integer.parseInt(args[3]);
        int bonusHp = Integer.parseInt(args[4]);
        return new Weapon(name,ad, ap, bonusMana, bonusHp);
    }
}
