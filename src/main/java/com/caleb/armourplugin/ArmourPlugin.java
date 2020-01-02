package com.caleb.armourplugin;

import com.caleb.armourplugin.listeners.GiveArmourCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ArmourPlugin extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.println("Plugin works uwu!");
        this.getCommand("givearmour").setExecutor(new GiveArmourCommand());
    }
}
