package game.comandmanager.shop;

import characters.Player;
import structure.Shop;

public interface ShopAction {

    boolean execute(int itemIndex, Player player, Shop shop);
}
