package game.comandmanager.shop;

import game.Item;
import game.Player;

import java.util.List;

public interface ShopAction {

    boolean execute(int itemIndex, Player player, Item... items);
}
