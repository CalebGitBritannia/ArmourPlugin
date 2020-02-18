package com.caleb.armourplugin.GUIs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainGUI extends GuiAbstract implements Listener {

    public MainGUI() {
        super("Armour Selection", 9);
    }

    @Override
    public void initaliseItems() {
        this.getInventory().addItem(createGuiItem(Material.PACKED_ICE, "§bFrostbite Armour"));
        this.getInventory().addItem(createGuiItem(Material.ANVIL, "§3Jungle Armour"));
        this.getInventory().addItem(createGuiItem(Material.POTION, "§7Spring Armour"));
    }

    @EventHandler
    public void onOpen(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Armour Selection")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            GuiAbstract menu = null;
            player.playSound(player.getLocation(), Sound.SLIME_ATTACK, 1, 1);
            if (e.getCurrentItem()!=null &&  e.getCurrentItem().getType().equals(Material.PACKED_ICE)) {
                menu = new FrostbiteArmourGUI();
            } else if (e.getCurrentItem()!=null &&  e.getCurrentItem().getType().equals(Material.ANVIL)) {
                menu = new JungleArmourGUI();
            }else if (e.getCurrentItem()!=null &&  e.getCurrentItem().getType().equals(Material.POTION)) {
                menu = new SpringArmourGIO();
            }
            if (menu != null) {
                menu.initaliseItems();
                menu.openInventory(player);
            }
        }
    }
}
