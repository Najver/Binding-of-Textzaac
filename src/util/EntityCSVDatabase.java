package util;

import characters.Boss;
import characters.Entity;
import items.Weapon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntityCSVDatabase {

    private static final List<Entity> entities = parseAllEntities();

    public static List<Boss> getAllBosses(){
        List<Boss> bosses = new ArrayList<>();
        for (Entity entity : entities)
            if (entity instanceof Boss)
                bosses.add((Boss) entity);
        return bosses;
    }
    public static List<Entity> getAllCasuals() {
        List<Entity> entitiesList = new ArrayList<>();
        for (Entity entity : entities)
        {
            if (entity instanceof Boss)
                continue;
            entitiesList.add(entity);
        }
        return entitiesList;
    }

    private static List<Entity> parseAllEntities() {
        ArrayList<Entity> entitiesArray = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/Entities.csv"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] args = line.split(";");
                Entity entity = createEntity(args);
                entitiesArray.add(entity);
            }
        }catch(IOException e){
            System.err.println("EntityCSVDatabase error: Could not load file");
        }
        return entitiesArray;

    }

    private static Entity createEntity(String[] args) {
        String name = args[0];
        int maxHp = Integer.parseInt(args[1]);
        int damage = Integer.parseInt(args[2]);
        boolean isBoss = Boolean.parseBoolean(args[3]);
        return isBoss ? new Boss(name, maxHp, damage) : new Entity(name, maxHp, damage);
    }

}
