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
import org.bukkit.util.Vector;

public class EventsClass implements Listener {

    private Plugin plugin;

    public EventsClass(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (CalebAPI.wearingDrumArmour(player,"Frostbite")) {
                if (CalebAPI.getRandomNumberInRange(1,5) == 1) {
                    if (e.getDamager() instanceof Player && !CalebAPI.gotFrost((Player) e.getDamager())) {
                        LivingEntity living = (LivingEntity) e.getDamager();
                        player.getWorld().playSound(player.getLocation(), Sound.GLASS, 10, 1);
                        int effect = 1;
                        System.out.println(CalebAPI.getFrost(player, "Frostbite"));
                        switch (CalebAPI.getFrost(player, "Frostbite")) {
                            case(1):
                                effect = 1;
                                break;
                            case(2):
                                effect = 2;
                                break;
                            case(3):
                                effect = 3;
                                break;
                        }
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 10, effect));
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
            } else if (CalebAPI.wearingDrumArmour(player, "Jungle")) {
                player.getWorld().playSound(player.getLocation(), Sound.ANVIL_LAND, 10, 1);
                BukkitTask knick = new EventsClass.knockBack(player, CalebAPI.getFrost(player, "Jungle"), plugin).runTaskLater(plugin, 1);
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

    public static class knockBack extends BukkitRunnable {

        private Player player;
        private int damage;
        private Plugin plugin;

        knockBack(Player player, int damage, Plugin plugin) {
            this.player = player;
            this.damage = damage;
            this.plugin = plugin;
        }

        public void run() {
            double multiplier = 0.5;
            switch(damage){
                case(1):
                    multiplier = plugin.getConfig().getDouble("little-knockback-1");
                    break;
                case(2):
                    multiplier = plugin.getConfig().getDouble("little-knockback-2");
                    break;
                case(3):
                    multiplier = plugin.getConfig().getDouble("little-knockback-3");
                    break;
            }
            Vector vector = player.getVelocity();
            vector.setX(player.getVelocity().getX() * multiplier);
           // vector.setY(player.getVelocity().getY() * multiplier);
            vector.setZ(player.getVelocity().getZ() * multiplier);
            player.setVelocity(vector);
        }
    }
}
