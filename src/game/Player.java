package game;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Item> playerInventory;

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public String getName() {
        return name;
    }

    public void setPlayerInventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
    }
}
