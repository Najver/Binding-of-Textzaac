package game.comandmanager.room;

import characters.Player;
import structure.MapLevel;

public interface CommandActions {

    void execute(String parameter, Player player, Room room);

}
