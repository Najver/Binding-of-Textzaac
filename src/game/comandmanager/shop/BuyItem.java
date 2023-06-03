package game.comandmanager.shop;

import game.Item;
import game.Player;
import game.Room;


public class BuyItem implements ShopAction {

    @Override
    public boolean execute(int itemIndex, Player player, Item... items) {
        Item boughtItem = items[itemIndex];
        if(itemIndex == 0 && player.getCoins() < 15 || itemIndex == 1 && player.getCoins() < 10 || itemIndex == 2 && player.getCoins() < 5)
            return false;
        player.getPlayerInventory().add(boughtItem);
        items[itemIndex] = null;
        return true;
    }
}
