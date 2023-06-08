package game;

import characters.Entity;
import characters.Player;
import game.comandmanager.combat.AttackAction;
import game.comandmanager.combat.CombatAction;
import game.comandmanager.combat.UseConsumableAction;
import items.Weapon;
import util.ConsoleColors;

import java.util.Arrays;
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

    /**
     * First massage so you know you are fighting
     * @return whether player has won the battle
     */
    public static boolean startCombat(Player player, Entity enemy)
    {
        System.out.println(ConsoleColors.RED.colorCode + "Welcome to the cumbat\n\nRules are simple, you attack, then your opponent attacks, until one of you dies. Fight!" + ConsoleColors.RESET.colorCode);
        System.out.println(ConsoleColors.RED.colorCode + "You are fighting against " + enemy.getName() + ConsoleColors.RESET.colorCode);
        return proceedCombat(player, enemy);
    }

    /**
     * combat between player and enemy
     */

    private static boolean proceedCombat(Player player, Entity enemy) {
        int playerADamage;
        int playerAPDamage;
        countRemainingBonus(player);
        while (player.getHp() > 0 && enemy.getHp() > 0)
        {
            playerADamage = 10 + countRemainingDamage(player, 0);
            playerAPDamage = countRemainingDamage(player, 1);
            System.out.println("You have " + player.getHp());
            System.out.println("What do you do?\nYou have this consumables: " + player.getAllPlayersConsumables() +
                    "\nYour damage is: AD = " + playerADamage + ", AP = " + playerAPDamage);
            processCommand(player, enemy, playerADamage, playerAPDamage);
            enemyAttack(player, enemy);
        }
        return player.getHp() > 0;
    }

    /**
     * method for enemy attack
     */



    private static void enemyAttack(Player player, Entity enemy) {
        int enemyDmg = enemy.getDamage();
        int playerCurrentHealth = player.getHp();
        player.setHp(playerCurrentHealth - enemyDmg);
        System.out.println(ConsoleColors.RED.colorCode + "Enemy dealt you " + enemyDmg + "and left you with " + player.getHp() + ConsoleColors.RESET.colorCode);
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
        System.out.println(additionalDamage);
        return additionalDamage;
    }

    private static void countRemainingBonus(Player player)
    {
        for (Weapon weapon : player.getAllPlayersWeapons()) {
            int hpBonus = weapon.getBonusHp();
            int manaBonus = weapon.getBonusMana();

            player.setMaxHp(player.getHp() + hpBonus);
            player.setHp(player.getHp() + hpBonus);

            player.setMaxMana(player.getMana() + manaBonus);
            player.setMana(player.getMana() + manaBonus);
        }
    }

}
