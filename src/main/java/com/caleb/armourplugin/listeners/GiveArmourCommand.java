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
            if(strings.length > 0) {
                if (strings[0].equalsIgnoreCase("drumislandhelmet")) {
                    giveCustomArmour((ChatColor.AQUA + "Drum Island Helmet"), 1, (Player) commandSender, Material.DIAMOND_HELMET);
                }  else if(strings[0].equalsIgnoreCase("drumislandchestplate")) {
                    giveCustomArmour((ChatColor.AQUA + "Drum Island Chestplate"), 1, (Player) commandSender, Material.DIAMOND_CHESTPLATE);
                } else if(strings[0].equalsIgnoreCase("drumislandleggings")) {
                    giveCustomArmour((ChatColor.AQUA + "Drum Island Leggings"), 1, (Player) commandSender, Material.DIAMOND_LEGGINGS);
                } else if(strings[0].equalsIgnoreCase("drumislandboots")) {
                    giveCustomArmour((ChatColor.AQUA + "Drum Island Boots"), 1, (Player) commandSender, Material.DIAMOND_BOOTS);
                }



                else {
                    commandSender.sendMessage("Sorry but that item is not recognised!");
                }
                return true;
            } else {
                System.out.println("Need an argument");
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
        armourItem.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, protection);
        player.getInventory().addItem(armourItem);
    }
}
