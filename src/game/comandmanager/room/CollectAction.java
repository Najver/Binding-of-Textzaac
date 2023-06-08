package game.comandmanager.room;

import items.Item;
import characters.Player;
import structure.MapLevel;

import java.util.ArrayList;
import java.util.List;

public class CollectAction implements CommandActions {
    /**
     * you collect item
     * @param parameter
     * @param player
     * @param mapLevel
     */
    @Override
    public void execute(String parameter, Player player, MapLevel mapLevel) {
        int sizeOfItems = player.getCurentRoom().getItems().size();
        List<Item> currentRoomItems = player.getCurentRoom().getItems();
        for (int i = 0; i < sizeOfItems; i++) {
            Item currentItem = currentRoomItems.get(i);
            if(currentItem.getName().equals(parameter)){
                player.getPlayerInventory().add(currentItem); //Capsule
                currentRoomItems.remove(currentItem);
                return;
            }
        }
    }
}
