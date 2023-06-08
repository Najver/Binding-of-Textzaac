package main;

import characters.Player;
import game.comandmanager.room.CollectAction;
import game.comandmanager.room.CommandActions;
import game.comandmanager.room.MovementAction;
import structure.MapLevel;
import structure.room.BossRoom;
import structure.room.Shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Console {


    private String buffer;

    private Scanner scanner;

    private static Map<String, CommandActions> commands;


    public Console() {
        this.scanner = new Scanner(System.in);
        commands = new HashMap<>();
        commands.put("collect", new CollectAction());
        commands.put("go", new MovementAction());
    }

    /**
     * this is where the player can play the game and has few commands to play with
     */
    public void startGame(Game game) {
        System.out.println("Welcome to the game! You are at spawn, where you want to move? \n");
        int currentActiveMapIndex = game.getCurrentActiveMap();
        showMap(game.getAllLevels().get(currentActiveMapIndex));
        System.out.println("You are currently at: " + game.getPlayer().getCurentRoom());
        System.out.println("You found this:" + game.getPlayer().getCurentRoom().getItems());
        while (game.getAllLevels().get(currentActiveMapIndex).isBossAlive())
        {
            currentActiveMapIndex = game.getCurrentActiveMap();
            buffer = scanner.nextLine();
            processCommand(buffer, game.getAllLevels().get(currentActiveMapIndex), game.getPlayer());
            System.out.println("You are currently at: " + game.getPlayer().getCurentRoom());
            System.out.println("You found this:" + game.getPlayer().getCurentRoom().getItems());
            buffer = "";
            if (game.getPlayer().getCurentRoom() instanceof Shop)
                game.getAllLevels().get(currentActiveMapIndex).openShop(game.getPlayer(), (Shop) game.getPlayer().getCurentRoom());
            if (game.getPlayer().getCurentRoom() instanceof BossRoom && game.getAllLevels().get(currentActiveMapIndex).isBossAlive())
            {
                boolean playerWon = game.getAllLevels().get(currentActiveMapIndex).startBossFight(game.getPlayer(), game.getPlayer().getCurentRoom().getEnemy());
                if (playerWon) {
                    moveToNextRoom(game, game.getPlayer(),currentActiveMapIndex);
                    currentActiveMapIndex += 1;
                }

            }
        }
    }

    private void processCommand(String answer, MapLevel map, Player player) {
        String[] args = answer.split(" ", 2);
        if(args.length == 1){
            System.out.println("missing argument");
            return;
        }
        if (commands.containsKey(args[0]))
            commands.get(args[0]).execute(args[1], player, map);

    }

    private void showMap(MapLevel mapLevel)
    {
        mapLevel.printMap();
    }

    /**
     *moving through the map
     */

    private void moveToNextRoom(Game game, Player player, int currentIndex) {
        game.setCurrentActiveMap(currentIndex + 1);
        System.out.println("You have moved to the next room");
        MapLevel newMap = game.getAllLevels().get(game.getCurrentActiveMap());
        showMap(newMap);
        player.setCurrentRoom(newMap.getSpawn());
    }

    public static Map<String, CommandActions> getCommands() {
        return commands;
    }
}
