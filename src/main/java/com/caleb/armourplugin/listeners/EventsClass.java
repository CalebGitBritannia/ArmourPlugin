package com.caleb.armourplugin.listeners;

import com.caleb.armourplugin.CalebAPI;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventsClass implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
            Player player = (Player) e.getEntity();
            if (CalebAPI.wearingDrumArmour(player)) {
                if (CalebAPI.getRandomNumberInRange(1,5) == 1) {
                    if (e.getDamager() instanceof Player) {
                        System.out.println("sLOWED");
                        LivingEntity living = (LivingEntity) e.getDamager();
                        player.getWorld().playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 3));
                    }
                }
            } else {
                System.out.println("He is not wearing");
                e.setCancelled(true);
            }
        }
    }
}
