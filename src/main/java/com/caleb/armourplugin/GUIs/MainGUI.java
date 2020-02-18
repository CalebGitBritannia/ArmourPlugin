package com.caleb.armourplugin.GUIs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainGUI extends GuiAbstract implements Listener {

    public MainGUI() {
        super("Armour Selection");
    }

    public void initializeItems() {
        this.getInventory().addItem(createGuiItem(Material.PACKED_ICE, "§bFrostbite Armour"));
    }

    @EventHandler
    public void onOpen(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Armour Selection")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem()!=null &&  e.getCurrentItem().getType().equals(Material.PACKED_ICE)) {
                player.sendMessage(ChatColor.BLUE + "Test!");
                player.closeInventory();
//                if (e.getClick().equals(ClickType.RIGHT)) {
//                    player.sendMessage(ChatColor.RED + "This is a passive skill, you cannot use it");
//                } else {
//                    player.sendMessage(ChatColor.BLUE + "You have selected the freeze protect skill");
//                    player.closeInventory();
//                }
                //ArmourSkills.freezeProtect(player);
            }
        }
    }
}
