package main;

import characters.Player;
import items.Consumable;
import structure.MapLevel;
import util.ConsumablesCSVDatabase;
import util.WeaponCSVDatabase;

import java.util.List;

public class Game {

    private List<MapLevel> allLevels;

    private Console console;

    private Player player;

    private int currentActiveMap;

    public Game(String nameOfThePlayer)
    {
        MapLevel SmallMap = new MapLevel("SmallMap");
        MapLevel FrozenDungeon = new MapLevel("FrozenDungeon");

        this.allLevels = List.of(SmallMap, FrozenDungeon);
        this.currentActiveMap = 0;
        this.console = new Console();
        this.player = new Player(nameOfThePlayer, allLevels.get(currentActiveMap));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(0));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(1));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(2));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(3));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(4));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(5));
        player.getPlayerInventory().add(ConsumablesCSVDatabase.getConsumable().get(6));

        player.getPlayerInventory().add(WeaponCSVDatabase.getWeapons().get(0));
        player.getPlayerInventory().add(WeaponCSVDatabase.getWeapons().get(3));
        player.getPlayerInventory().add(WeaponCSVDatabase.getWeapons().get(5));

    }

    public void startGame()
    {
        console.startGame(this);
    }

    public List<MapLevel> getAllLevels() {
        return allLevels;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCurrentActiveMap(int currentActiveMap) {
        this.currentActiveMap = currentActiveMap;
    }

    public int getCurrentActiveMap() {
        return currentActiveMap;
    }
}
