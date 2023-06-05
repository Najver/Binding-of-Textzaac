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

    public void startGame(Game game) {
        System.out.println("Welcome to the game! You are at spawn, where you want to move? \n");
        int currentActiveMapIndex = game.getCurrentActiveMap();
        showMap(game.getAllLevels().get(currentActiveMapIndex));
        System.out.println("You are currently at: " + game.getPlayer().getCurentRoom());
        while (game.getAllLevels().get(currentActiveMapIndex).isBossAlive())
        {
            buffer = scanner.nextLine();
            processCommand(buffer, game.getAllLevels().get(currentActiveMapIndex), game.getPlayer());
            System.out.println("You are currently at: " + game.getPlayer().getCurentRoom());
            buffer = "";
            if (game.getPlayer().getCurentRoom() instanceof Shop)
                game.getAllLevels().get(currentActiveMapIndex).openShop(game.getPlayer(), (Shop) game.getPlayer().getCurentRoom());
            if (game.getPlayer().getCurentRoom() instanceof BossRoom)
                game.getAllLevels().get(currentActiveMapIndex).startBossFight(game.getPlayer(), game.getPlayer().getCurentRoom().getEnemy());

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

    public static Map<String, CommandActions> getCommands() {
        return commands;
    }
}
