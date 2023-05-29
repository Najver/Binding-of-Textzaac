package game.comandmanager;

import game.Item;
import game.Player;
import game.Room;

import java.util.List;

public interface CommandActions {

    void execute(String parameter, Player player, Room room);

}
