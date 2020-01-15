package com.caleb.armourplugin.listeners;

import com.caleb.armourplugin.CalebAPI;
import com.caleb.armourplugin.RollBack.RollBack;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
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
import org.bukkit.scheduler.BukkitTask;

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
                        player.getWorld().playSound(player.getLocation(), Sound.GLASS, 10, 1);
                        player.getWorld().playEffect(player.getLocation(), Effect.COLOURED_DUST, 1);
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 10, 3));
                        RollBack newRoll = new RollBack(player.getLocation(), 6);
                        for (int x = -6; x < 6; x++ ) {
                            for (int z = -6; z < 6; z++) {
                                Location location = player.getLocation();
                                location.setZ(player.getLocation().getZ() + z);
                                location.setX(player.getLocation().getX() + x);
                                for(int y = (int) (player.getLocation().getY() + 2); y > 0; y--) {
                                    location.setY(y);
                                    if (location.getBlock().getType() != Material.AIR && location.getBlock().getType() != Material.LONG_GRASS) {
                                        int guesser = (int) (Math.random() * 10);
                                        if (guesser > 8) {
                                            newRoll.addBlock(location.getBlock());
                                            location.getBlock().setType(Material.PACKED_ICE);
                                        }
                                        break;
                                    }
                                }
                            }
                        } BukkitTask task1 = new EventsClass.throwTask(newRoll).runTaskLater(plugin, 20*10);


                    }
                }
            } else {
                System.out.println("He is not wearing");
                e.setCancelled(true);
            }
        }
    }

    public static class throwTask extends BukkitRunnable {

        private RollBack rollBack;

        throwTask(RollBack rollBack) {
            this.rollBack = rollBack;
        }

        public void run() {
            rollBack.restoreState();
        }
    }
}
