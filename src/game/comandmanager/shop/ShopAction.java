package game.comandmanager.shop;

import game.Item;
import game.Player;
import game.Shop;

import java.util.List;

public interface ShopAction {

    boolean execute(int itemIndex, Player player, Shop shop);
}
