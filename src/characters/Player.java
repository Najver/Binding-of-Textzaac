package characters;

import items.Item;
import structure.MapLevel;
import structure.Room;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int mana;
    private int coins;
    private ArrayList<Item> playerInventory;
    private Room curentRoom;


    public Player(String name, MapLevel level) {
        this.name = name;
        this.hp = 100;
        this.mana = 50;
        this.coins = 30;            // sebrat
        this.playerInventory = new ArrayList<>();
        this.curentRoom = level.getSpawn();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public ArrayList<Weapon> getAllPlayersWeapons()
    {
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (Item item : playerInventory) {
            Weapon weapon;
            try {
                weapon = (Weapon) item;
                weapons.add(weapon);
            }
            catch (ClassCastException ignored) {}
        }
        return weapons;
    }

    public ArrayList<Consumable> getAllPlayersConsumables()
    {
        ArrayList<Consumable> weapons = new ArrayList<>();
        for (Item item : playerInventory) {
            Consumable consumable;
            try {
                consumable = (Consumable) item;
                weapons.add(consumable);
            }
            catch (ClassCastException ignored) {}
        }
        return weapons;
    }

    public String getName() {
        return name;
    }

    public void setPlayerInventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
    }

    public Room getCurentRoom() {
        return curentRoom;
    }

    public void setCurentRoom(Room curentRoom) {
        this.curentRoom = curentRoom;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' + ", hp=" + hp + ", mana=" + mana + ", coins=" + coins + ", playerInventory=" + playerInventory + '}';
    }
}
