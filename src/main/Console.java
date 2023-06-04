package main;

import characters.Player;
import game.comandmanager.room.CollectAction;
import game.comandmanager.room.CommandActions;
import game.comandmanager.room.MovementAction;
import structure.MapLevel;

import java.util.HashMap;
import java.util.Map;

public class Console {
    private String buffer;

    private static Map<String, CommandActions> commands;


    public Console() {
        commands = new HashMap<>();
        commands.put("Collect", new CollectAction());
    }

    public void startGame(Game game) {
        System.out.println("Welcome to the game! You are at spawn, where you want to move?");
        int currentActiveMapIndex = game.getCurrentActiveMap();
        showMap(game.getAllLevels().get(currentActiveMapIndex));
        System.out.println(game.getPlayer().getCurentRoom());
        while (true)
        {
            buffer = scanner.nextLine();
            processCommand(buffer, game.getAllLevels().get(currentActiveMapIndex), game.getPlayer());
            System.out.println(game.getPlayer().getCurentRoom());
            buffer = "";
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
