package util;

import items.Consumable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsumablesCSVDatabase {

    public static List<Consumable> getConsumable(){
        ArrayList<Consumable> consumables = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/Consumables.csv"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] args = line.split(";");
                Consumable consumable = createConsumable(args);
                if(consumable.getReturnHp() == -1 || consumable.getReturnMana() == -1)
                    continue;
                consumables.add(consumable);
            }
        }catch(IOException e) {
            System.err.println("ConsumableCSVDatabase error: Could not load file");
        }
        return consumables;
    }

    private static Consumable createConsumable(String[] args){
        String name = args[0];
        int returnHp = Integer.parseInt(args[1]);
        int returnMana = Integer.parseInt(args[2]);
        return new Consumable(name, returnHp, returnMana);
    }

    public static List<Consumable> getSpecial(){
        ArrayList<Consumable> consumables = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/Consumables.csv"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] args = line.split(";");
                Consumable consumable = createConsumable(args);
                if(consumable.getReturnHp() == -1 || consumable.getReturnMana() == -1)
                    consumables.add(consumable);
            }
        }catch(IOException e) {
            System.err.println("ConsumableCSVDatabase error: Could not load file");
        }
        return consumables;
    }
}
