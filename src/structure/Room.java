package structure;

import characters.Entities;
import characters.Player;
import items.Item;

import java.util.List;

public class Room {
    private List<Entities> enemies;

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
