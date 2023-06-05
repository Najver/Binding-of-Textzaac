package game.comandmanager.shop;

import characters.Player;
import structure.room.Shop;

public class ExitShop implements ShopAction{
    @Override
    public boolean execute(int itemIndex, Player player, Shop shop) {
        return false;
    }
}
