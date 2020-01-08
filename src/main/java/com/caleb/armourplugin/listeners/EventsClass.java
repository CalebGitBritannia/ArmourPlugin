package com.caleb.armourplugin.listeners;

import com.caleb.armourplugin.CalebAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventsClass implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (CalebAPI.wearingDrumArmour(player)) {
                System.out.println("He is wearing");
            } else {
                System.out.println("He is not wearing");
            }
        }
    }
}
