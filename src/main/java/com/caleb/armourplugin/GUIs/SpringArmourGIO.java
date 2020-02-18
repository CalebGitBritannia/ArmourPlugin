package com.caleb.armourplugin.GUIs;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SpringArmourGIO extends GuiAbstract implements Listener {

    private final Inventory inv;

    public SpringArmourGIO() {
        super("Spring Armour", 54);
        this.inv = getInventory();
    }

    @Override
    public void initaliseItems() {
        inv.setItem(12, createGuiItem(Material.DIAMOND_HELMET, "§f§k0 §f§l- §1§lSpring Helmet 1 §f§l- §f§k0 "));
        inv.setItem(21, createGuiItem(Material.DIAMOND_CHESTPLATE, "§f§k0 §f§l- §1§lSpring Chestplate 1 §f§l- §f§k0 "));
        inv.setItem(30, createGuiItem(Material.DIAMOND_LEGGINGS, "§f§k0 §f§l- §1§lSpring Leggings 1 §f§l- §f§k0 "));
        inv.setItem(39, createGuiItem(Material.DIAMOND_BOOTS, "§f§k0 §f§l- §1§lSpring Boots 1 §f§l- §f§k0 "));
        inv.setItem(13, createGuiItem(Material.DIAMOND_HELMET, "§f§k0 §f§l- §1§lSpring Helmet 2 §f§l- §f§k0 "));
        inv.setItem(22, createGuiItem(Material.DIAMOND_CHESTPLATE, "§f§k0 §f§l- §1§lSpring Chestplate 2 §f§l- §f§k0 "));
        inv.setItem(31, createGuiItem(Material.DIAMOND_LEGGINGS, "§f§k0 §f§l- §1§lSpring Leggings 2 §f§l- §f§k0 "));
        inv.setItem(40, createGuiItem(Material.DIAMOND_BOOTS, "§f§k0 §f§l- §1§lSpring Boots 2 §f§l- §f§k0 "));
        inv.setItem(14, createGuiItem(Material.DIAMOND_HELMET, "§f§k0 §f§l- §1§lSpring Helmet 3 §f§l- §f§k0 "));
        inv.setItem(23, createGuiItem(Material.DIAMOND_CHESTPLATE, "§f§k0 §f§l- §1§lSpring Chestplate 3 §f§l- §f§k0 "));
        inv.setItem(32, createGuiItem(Material.DIAMOND_LEGGINGS, "§f§k0 §f§l- §1§lSpring Leggings 3 §f§l- §f§k0 "));
        inv.setItem(41, createGuiItem(Material.DIAMOND_BOOTS, "§f§k0 §f§l- §1§lSpring Boots 3 §f§l- §f§k0 "));
    }

    @EventHandler
    public void onOpen(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Spring Armour")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spring")) {
                player.getInventory().addItem(e.getClickedInventory().getItem(e.getSlot()));
            }
        }
    }
}