package game;

import java.util.List;

public class Room {
    private List<Entities> enemies;

    private List<Item> items;

    private String name;

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
