package main;

import characters.Player;
import structure.MapLevel;

import java.util.List;

public class Game {

    private List<MapLevel> allLevels;

    private Console console;

    private Player player;

    private int currentActiveMap;

    public Game(String nameOfThePlayer)
    {
        MapLevel FrozenDungeon = new MapLevel("FrozenDungeon");

        this.allLevels = List.of(FrozenDungeon);
        this.currentActiveMap = 0;
        this.console = new Console();
        this.player = new Player(nameOfThePlayer, allLevels.get(currentActiveMap));
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

    public int getCurrentActiveMap() {
        return currentActiveMap;
    }
}
