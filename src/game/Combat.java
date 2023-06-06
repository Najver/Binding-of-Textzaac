package game;

import characters.Entity;
import characters.Player;
import game.comandmanager.combat.AttackAction;
import game.comandmanager.combat.CombatAction;
import game.comandmanager.combat.UseConsumableAction;
import items.Item;
import items.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Combat {

    private static Scanner scanner = new Scanner(System.in);

    private static Map<String, CombatAction> combatActionMap = new HashMap<>();

    static
    {
        combatActionMap.put("use", new UseConsumableAction());
        combatActionMap.put("attack", new AttackAction());
    }

    public static boolean startCombat(Player player, Entity enemy)
    {
        System.out.println("Welcome to the cumbat\n\nRules are simple, you attack, then your opponent attacks, until one of you dies. Fight!");
        System.out.println("You are fighting against " + enemy.getName());
        return proceedCombat(player, enemy);
    }

    private static boolean proceedCombat(Player player, Entity enemy) {
        int playerADamage = 10 + countRemainingDamage(player, 0);
        int playerAPDamage = countRemainingDamage(player, 1);
        while (player.getHp() > 0 && enemy.getHp() > 0)
        {
            System.out.println("What do you do?\nYou have this consumables: " + player.getAllPlayersConsumables() +
                    "\nYour damage is: AD = " + playerADamage + ", AP = " + playerAPDamage);
            processCommand(player, enemy, playerADamage, playerAPDamage);
        }
        return player.getHp() > 0;
    }

    private static void processCommand(Player player, Entity enemy, int playerADDamage, int playerAPDamage) {
        String buffer = scanner.nextLine();
        String[] args = buffer.split(" ", 2);
        if (args.length == 1)
        {
            System.out.println("You've forgotten for parameter");
            return;
        }
        if (combatActionMap.containsKey(args[0]))
            combatActionMap.get(args[0]).execute(args[1], player, enemy, playerADDamage, playerAPDamage);
    }

    private static int countRemainingDamage(Player player, int typeOfDamage)
    {
        int additionalDamage = 0;
        for (Weapon weapon : player.getAllPlayersWeapons()){
            if (typeOfDamage == 0)
                additionalDamage += weapon.getAd();
            else
                additionalDamage += weapon.getAp();
        }
        return additionalDamage;
    }

}
