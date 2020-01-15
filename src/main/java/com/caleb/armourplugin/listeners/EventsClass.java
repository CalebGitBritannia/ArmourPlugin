package com.caleb.armourplugin.listeners;

import com.caleb.armourplugin.CalebAPI;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EventsClass implements Listener {

    private Plugin plugin;

    public EventsClass(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (CalebAPI.wearingDrumArmour(player)) {
                if (CalebAPI.getRandomNumberInRange(1,5) == 1) {
                    if (e.getDamager() instanceof Player && !CalebAPI.gotFrost((Player) e.getDamager())) {
                        LivingEntity living = (LivingEntity) e.getDamager();
                        player.getWorld().playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                        player.getWorld().playEffect(player.getLocation(), Effect.COLOURED_DUST, 1);
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 10, 3));
                    }
                }
            } else {
                System.out.println("He is not wearing");
                e.setCancelled(true);
            }
        }
    }
}
