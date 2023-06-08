package structure.room;

import characters.Entity;
import characters.Player;
import items.Consumable;
import items.Item;
import items.Weapon;
import util.ConsumablesCSVDatabase;
import util.EntityCSVDatabase;
import util.WeaponCSVDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Room {
    protected Entity enemy;

    private List<Item> items;

    private int[] indices;

    protected String name;
    protected Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room(String name, int x, int y){
        this.name = name;
        this.indices = new int[] {x, y};
        this.items = new ArrayList<>();
        this.enemy = spawnEnemy();
        spawnItems();
    }

    public void setEnemy(Entity enemy){
        this.enemy = enemy;
    }

    public Entity getEnemy() {
        return enemy;
    }

    @Override
    public String toString() {
        if (enemy != null)
            return name + "☠";
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public int[] getIndices() {
        return indices;
    }

    private Entity spawnEnemy(){
        Random random = new Random();
        List<Entity> entities = EntityCSVDatabase.getAllCasuals();
        if(isNotGoingToSpawn(random)){
            return null;
        }
        return entities.get(random.nextInt(entities.size()));
    }

    private boolean isNotGoingToSpawn(Random random) {
        return (random.nextInt(4) == 3);
    }

    /**
     * methods to spawn items in the rooms
     * @return items
     */
    private Weapon spawnWeapon(){
        Random random = new Random();
        return WeaponCSVDatabase.getWeapons().get(random.nextInt(WeaponCSVDatabase.getWeapons().size()));
    }

    private Consumable spawnConsumable(){
        Random random = new Random();
        return ConsumablesCSVDatabase.getConsumable().get(random.nextInt(ConsumablesCSVDatabase.getConsumable().size()));
    }

    private void spawnItems(){
        Random random = new Random();
        if (random.nextBoolean())
            items.add(spawnWeapon());
        else
            items.add(spawnConsumable());
    }


}
