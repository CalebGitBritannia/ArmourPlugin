package com.caleb.armourplugin;

import com.caleb.armourplugin.GUIs.MainGUI;
import com.caleb.armourplugin.listeners.EventsClass;
import com.caleb.armourplugin.listeners.GiveArmourCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ArmourPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin works uwu!");
        createConfig();
        this.getCommand("givearmour").setExecutor(new GiveArmourCommand());
        getServer().getPluginManager().registerEvents(new EventsClass(this), this);
        getServer().getPluginManager().registerEvents(new MainGUI(), this);
    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
