package com.caleb.armourplugin;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class CalebAPI {
    public static boolean wearingDrumArmour(Player player, String string) {
        int count = 0;
        ItemStack[] inventory = player.getInventory().getArmorContents();
        for (int i = 0; i<inventory.length; i++) {
            if (inventory[i].getItemMeta() != null) {
                if(inventory[i].getItemMeta().getDisplayName().contains(string)) {
                    count += 1;
                }
            }
        }
        return count ==4 ;
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static boolean gotFrost(Player player) {
        for(PotionEffect effect : player.getActivePotionEffects()) {
            if (effect.getType().equals(PotionEffectType.SLOW)) {
                return true;
            }
        } return false;
    }

    public static int getFrost(Player player, String name) {
        int count = 0;
        ItemStack[] inventory = player.getInventory().getArmorContents();
        for (int i = 0; i<inventory.length; i++) {
            if (inventory[i].getItemMeta() != null) {
                if(inventory[i].getItemMeta().getDisplayName().contains(name)) {
                    count += (int) inventory[i].getItemMeta().getDisplayName().charAt(inventory[i].getItemMeta().getDisplayName().length() - 1) - 48;
                }
            }
        }
        return (int) count / 4;
    }
}
