package characters;

import items.Consumable;
import items.Item;
import items.Weapon;
import structure.MapLevel;
import structure.room.Room;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int mana;
    private int coins;

    private int maxMana;
    private int maxHp;
    private ArrayList<Item> playerInventory;
    private Room curentRoom;


    public Player(String name, MapLevel level) {
        this.name = name;
        this.hp = 100;
        this.mana = 50;
        this.maxHp = 100;
        this.maxMana = 50;
        this.coins = 30;            // sebrat
        this.playerInventory = new ArrayList<>();
        this.curentRoom = level.getSpawn();
    }

    public int getHp() {
        return hp;
    }

    public boolean setHp(int hp) {
        if (!(this.hp + hp >= maxHp))
        {
            this.hp = hp;
            return true;
        }
        return false;
    }

    public int getMana() {
        return mana;
    }

    public boolean setMana(int mana) {
        if (this.mana + mana > maxMana)
        {
            this.mana = mana;
            return true;
        }
        return false;
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

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setCurrentRoom(Room curentRoom) {
        this.curentRoom = curentRoom;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' + ", hp=" + hp + ", mana=" + mana + ", coins=" + coins + ", playerInventory=" + playerInventory + '}';
    }
}
