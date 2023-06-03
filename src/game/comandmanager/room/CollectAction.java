package game.comandmanager.room;

import game.Item;
import game.Player;
import game.Room;

public class CollectAction implements CommandActions {
    @Override
    public void execute(String parameter, Player player, Room room) {
        for (Item item:room.getItems()) {
            if(item.getName().equals(parameter)){
                player.getPlayerInventory().add(item); //Capsule
                room.getItems().remove(item);
                return;
            }
        }
    }
}
