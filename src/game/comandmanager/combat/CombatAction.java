package game.comandmanager.combat;

import characters.Entity;
import characters.Player;

public interface CombatAction {
    void execute(String parameter, Player player, Entity entity, int ad, int ap);
}
