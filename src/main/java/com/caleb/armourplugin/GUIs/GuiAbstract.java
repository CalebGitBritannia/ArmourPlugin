package com.caleb.armourplugin.GUIs;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import java.util.ArrayList;

public class GuiAbstract implements InventoryHolder {
    private final Inventory inv;
    private String title;

    public GuiAbstract(String title) {
        inv = Bukkit.createInventory(this, 9, title);
        this.title = title;
    }

    // Nice little method to create a gui item with a custom name, and description
    public static  ItemStack createGuiItem(Material material, String name, String...lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> metalore = new ArrayList<String>();

        for(String lorecomments : lore) {

            metalore.add(lorecomments);

        }

        meta.setLore(metalore);
        item.setItemMeta(meta);
        return item;
    }

    public Inventory getInventory() {
        return inv;
    }

    public void openInventory(Player p) {
        p.openInventory(inv);
    }
}