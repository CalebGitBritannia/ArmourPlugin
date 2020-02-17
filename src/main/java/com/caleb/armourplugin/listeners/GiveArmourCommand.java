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
                if (value > 0 && value < 4) {
                    if (strings[0].equalsIgnoreCase("drumislandhelmet")) {
                        giveCustomArmour(("§f§k0 §f§l- §1§lFrostbite Helmet " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_HELMET);
                    } else if (strings[0].equalsIgnoreCase("drumislandchestplate")) {
                        giveCustomArmour(("§f§k0 §f§l- §1§lFrostbite Chestplate " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_CHESTPLATE);
                    } else if (strings[0].equalsIgnoreCase("drumislandleggings")) {
                        giveCustomArmour(("§f§k0 §f§l- §1§lFrostbite Leggings " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_LEGGINGS);
                    } else if (strings[0].equalsIgnoreCase("drumislandboots")) {
                        giveCustomArmour(("§f§k0 §f§l- §1§lFrostbite Boots " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_BOOTS);
                    } else if (strings[0].equalsIgnoreCase("littlegardenchestplate")) {
                        giveCustomArmour(("§f§k0 §f§l- §3§lSpring Chestplate " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_CHESTPLATE);
                    } else if (strings[0].equalsIgnoreCase("littlegardenleggings")) {
                        giveCustomArmour(("§f§k0 §f§l- §3§lJungle Leggings " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_LEGGINGS);
                    } else if (strings[0].equalsIgnoreCase("littlegardenboots")) {
                        giveCustomArmour(("§f§k0 §f§l- §3§lJungle Boots " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_BOOTS);
                    } else if (strings[0].equalsIgnoreCase("littlegardenhelmet")) {
                        giveCustomArmour(("§f§k0 §f§l- §3§lJungle Helmet " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_HELMET);
                    } else if (strings[0].equalsIgnoreCase("jayahelmet")) {
                        giveCustomArmour(("§f§k0 §f§l- §7§lSpring Helmet " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_HELMET);
                    } else if (strings[0].equalsIgnoreCase("jayachestplate")) {
                        giveCustomArmour(("§f§k0 §f§l- §7§lSpring Chestplate " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_CHESTPLATE);
                    } else if (strings[0].equalsIgnoreCase("jayaleggings")) {
                        giveCustomArmour(("§f§k0 §f§l- §7§lSpring Leggings " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_LEGGINGS);
                    } else if (strings[0].equalsIgnoreCase("jayaboots")) {
                        giveCustomArmour(("§f§k0 §f§l- §7§lSpring Boots " + strings[1] + " §f§l- §f§k0 "), 1, (Player) commandSender, Material.DIAMOND_BOOTS);
                    }else {
                        commandSender.sendMessage("Sorry but that item is not recognised!");
                    }
                } else {
                    commandSender.sendMessage("Please provide a valid number between 1 and 3");
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
