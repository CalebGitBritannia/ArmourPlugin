package com.caleb.armourplugin.listeners;

import com.caleb.armourplugin.CalebAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveArmourCommand implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(strings.length > 1) {
                int value = Integer.valueOf(strings[1]);
                if (value > 0 && value < 5) {
                    if (strings[0].equalsIgnoreCase("drumislandhelmet")) {
                        giveCustomArmour((ChatColor.AQUA + "Drum Island Helmet " + strings[1]), 1, (Player) commandSender, Material.DIAMOND_HELMET);
                    } else if (strings[0].equalsIgnoreCase("drumislandchestplate")) {
                        giveCustomArmour((ChatColor.AQUA + "Drum Island Chestplate " + strings[1]), 1, (Player) commandSender, Material.DIAMOND_CHESTPLATE);
                    } else if (strings[0].equalsIgnoreCase("drumislandleggings")) {
                        giveCustomArmour((ChatColor.AQUA + "Drum Island Leggings " + strings[1]), 1, (Player) commandSender, Material.DIAMOND_LEGGINGS);
                    } else if (strings[0].equalsIgnoreCase("drumislandboots")) {
                        giveCustomArmour((ChatColor.AQUA + "Drum Island Boots " + strings[1]), 1, (Player) commandSender, Material.DIAMOND_BOOTS);
                    }else {
                        commandSender.sendMessage("Sorry but that item is not recognised!");
                    }
                } else {
                    commandSender.sendMessage("Please provide a valid number between 1 and 4");
                }

                return true;
            } else {
                commandSender.sendMessage("(armour) (value)");
                return true;
            }
        }
        return false;
    }

    public static void giveCustomArmour(String name, int protection, Player player, Material armourType) {
        ItemStack armourItem = new ItemStack(armourType, 1);
        ItemMeta meta = armourItem.getItemMeta();
        meta.setDisplayName(name);
        armourItem.setItemMeta(meta);
        player.getInventory().addItem(armourItem);
    }
}
