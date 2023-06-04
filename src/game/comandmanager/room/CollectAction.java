package game.comandmanager.room;

import items.Item;
import characters.Player;
import structure.MapLevel;

public class CollectAction implements CommandActions {
    @Override
    public void execute(String parameter, Player player, MapLevel mapLevel) {
        for (Item item : player.getCurentRoom().getItems()) {
            if(item.getName().equals(parameter)){
                player.getPlayerInventory().add(item); //Capsule
                player.getCurentRoom().getItems().remove(item);
                return;
            }
        }
    }
}
