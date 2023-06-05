package structure;

import characters.Player;
import game.comandmanager.shop.BuyItem;
import game.comandmanager.shop.ShopAction;
import items.Item;
import main.Console;
import util.ConsoleColors;
import util.ConsumablesCSVDatabase;
import util.WeaponCSVDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Shop extends Room{

    private Map<String, ShopAction> map;
    private Random random;
    private Scanner scanner;
    private Item[] items;
    private boolean isPlayerPresent;

    public Shop(String name, int x, int y) {
        super(name, x, y);
        this.map = new HashMap<>();
        map.put("buy",new BuyItem());
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        int numberOfWeapons = WeaponCSVDatabase.getWeapons().size();
        int numberOfConsumables = ConsumablesCSVDatabase.getConsumable().size();
        int numberOfSpecials = ConsumablesCSVDatabase.getSpecial().size();
        Item itemWeapon = WeaponCSVDatabase.getWeapons().get(random.nextInt(numberOfWeapons));
        Item itemConsumable = ConsumablesCSVDatabase.getConsumable().get(random.nextInt(numberOfConsumables));
        Item itemSpecial = ConsumablesCSVDatabase.getSpecial().get(random.nextInt(numberOfSpecials));
        items = new Item[]{itemWeapon, itemConsumable, itemSpecial};
    }

    public void openShop(Player player){
        this.player = player;
        System.out.println("Hello i have 3 items you can buy");
        showAllItems();
        System.out.println("Do you wanna buy something?");
        String answer;
        isPlayerPresent = true;
        while  (!(answer = scanner.nextLine()).toLowerCase().contains("go ") || !isShopEmpty()) {
            processCommand(answer);
            if (isShopEmpty()) {
                System.out.println("nothing to buy");
                break;
            }
            showAllItems();
            System.out.println("Do you wanna buy something else?");
        }
        while(isPlayerPresent){
            answer = scanner.nextLine();
            processCommand("go");
        }
    }

    private int getIntInput(){
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    // upravit

    private void processCommand(String answer) {
        String[] args = answer.split(" ", 2);
        if(args.length == 1){
            System.out.println("missing argument");
            return;
        }
        int index = getItemIndex(args[1]);
        if (map.containsKey(args[0])) {
            if (!map.get(args[0]).execute(index, player, this))
                System.out.println("Not enough money");
        } else if (Console.getCommands().containsKey(args[0])) {
            Console.getCommands().get(args[0]).execute(args[1],player,null);
        } else
            System.out.println("comand wasnt recognized");
    }

    private int getItemIndex(String itemName) {
        int x = 0;
        for (Item item : items) {
            if (item != null)
                if (item.getName().equalsIgnoreCase(itemName))
                    return x;
            x++;
        }
        System.out.println("Item not found");
        return -1;
    }

    private void showAllItems(){
        StringBuilder allItems = new StringBuilder();
        for (Item item:items) {
            if(item != null)
                allItems.append(item).append("\n");
        }
        System.out.println(ConsoleColors.GREEN.colorCode + allItems + ConsoleColors.RESET.colorCode);
    }

    private boolean isShopEmpty(){
        boolean isEmpty = true;
        for (Item item : items)
            if(item != null)
                isEmpty = false;
        return isEmpty;
    }


    public Item[] getShopItems() {
        return items;
    }


}
