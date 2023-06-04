package game.comandmanager.shop;

import game.Item;
import game.Player;
import game.Room;
import game.Shop;


public class BuyItem implements ShopAction {

    @Override
    public boolean execute(int itemIndex, Player player, Shop shop){
        Item boughtItem = shop.getShopItems()[itemIndex];
        if(itemIndex == 0 && player.getCoins() < 15 || itemIndex == 1 && player.getCoins() < 10 || itemIndex == 2 && player.getCoins() < 5)
            return false;
        player.getPlayerInventory().add(boughtItem);
        int currentCoins = player.getCoins();
        switch (itemIndex)
        {
            case 0 -> player.setCoins(currentCoins - 15);
            case 1 -> player.setCoins(currentCoins - 10);
            case 2 -> player.setCoins(currentCoins - 5);
        }
        shop.getShopItems()[itemIndex] = null;
        return true;
    }
}
