package structure;

import characters.Entities;
import characters.Player;
import items.Item;

import java.util.List;

public class Room {
    private List<Entities> enemies;

    private List<Item> items;

    protected String name;
    protected Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
