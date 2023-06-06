package game.comandmanager.combat;

import characters.Entity;
import characters.Player;
import items.Consumable;

public class UseConsumableAction implements CombatAction{


    @Override
    public void execute(String parameter, Player player, Entity entity, int ad, int ap)
    {
        boolean foundItem = false;
        for (Consumable consumable : player.getAllPlayersConsumables()) {
            if (parameter.equalsIgnoreCase(consumable.getName()))
            {
                int recoverHP = consumable.getReturnHp();
                int recoverMana = consumable.getReturnMana();
                if (!player.setHp(player.getHp() + recoverHP))
                    System.out.println("You cannot heal yourself more!");
                if (!player.setMana(player.getMana() + recoverMana))
                    System.out.println("You cannot heal yourself more!");
                foundItem = true;
            }
        }
        if (!foundItem)
            System.err.println("The item which you chose does not exist in your inventory");
    }
}
