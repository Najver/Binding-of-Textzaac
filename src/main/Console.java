package main;

import game.comandmanager.room.CollectAction;
import game.comandmanager.CommandActions;

import java.util.HashMap;
import java.util.Map;

public class Console {
    private String buffer;

    private Map<String, CommandActions> commands;

    public Console() {
        commands = new HashMap<>();
        commands.put("Collect", new CollectAction());
    }

}
