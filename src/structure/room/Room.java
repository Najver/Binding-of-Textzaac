package structure.room;

import characters.Entity;
import characters.Player;
import items.Item;

import java.util.List;

public class Room {
    private Entity enemies;

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
    }

    public Entity getEnemy() {
        return enemies;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public int[] getIndices() {
        return indices;
    }
}
