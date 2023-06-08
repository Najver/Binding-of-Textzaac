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
        this.coins = 0;
        this.playerInventory = new ArrayList<>();
        this.curentRoom = level.getSpawn();
    }

    public int getHp() {
        return hp;
    }

    public boolean setHp(int hp) {
        if (hp > maxHp)
            return false;
        this.hp = hp;
        return true;
    }

    public int getMana() {
        return mana;
    }

    public boolean setMana(int mana) {
        if (mana > maxMana)
            return true;
        this.mana = mana;
        return true;
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

    /**
     *
     * @return you get all weapons from players inventory
     */

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

    /**
     *
     * @return you get all consumables from players inventory
     */

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

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxHp() {
        return maxHp;
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
