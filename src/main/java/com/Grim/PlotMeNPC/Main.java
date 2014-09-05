package com.Grim.PlotMeNPC;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Harrison on 26/08/14.
 */
public class Main extends JavaPlugin {

    public static Main plugin;

    public void onEnable(){
        plugin = this;

        getCommand("plotmenpc").setExecutor(new Commands());
        getCommand("plotmenu").setExecutor(new Commands());

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlotMeInv(), this);
        pm.registerEvents(new NPCListener(), this);
        new MobSchedule();

    }

    public void onDisable(){
        plugin = null;
    }
}
