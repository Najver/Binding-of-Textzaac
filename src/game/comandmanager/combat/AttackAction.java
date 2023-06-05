package game.comandmanager.combat;

import characters.Entity;
import characters.Player;

public class AttackAction implements CombatAction{
    @Override
    public void execute(String parameter, Player player, Entity entity, int ad, int ap) {
        if (parameter.equalsIgnoreCase("ad"))
        {
            int entityHp = entity.getHp();
            entity.setHp(entityHp - ad);
        }
        else if (parameter.equalsIgnoreCase("ap"))
        {
            int entityHp = entity.getHp();
            entity.setHp(entityHp - ap);
        }
        else
            System.err.println("You have entered a wrong parameter for this function");
    }
}
