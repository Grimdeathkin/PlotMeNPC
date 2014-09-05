package com.Grim.PlotMeNPC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Harrison on 26/08/14.
 */
public class MobSchedule {
    private List<String> uuidList = new ArrayList<String>();
    private Map<String, Location> locationMap = new HashMap<String, Location>();

    public MobSchedule(){
        Bukkit.getServer().getScheduler().cancelTasks(Main.plugin);
        FileConfiguration config = Main.plugin.getConfig();

        uuidList = config.getStringList("Mobs");

        for(String id : uuidList){
            Double x = config.getDouble(id + ".x");
            Double y = config.getDouble(id + ".y");
            Double z = config.getDouble(id + ".z");
            World world = Bukkit.getServer().getWorld(config.getString(id + ".world"));
            Location loc = new Location(world, x, y, z);
            locationMap.put(id, loc);
        }

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(Main.plugin, new BukkitRunnable() {

        @Override
            public void run() {
                for (World w : Main.plugin.getServer().getWorlds()) {
                    for (Entity e : w.getEntities()){
                        if(uuidList.contains(e.getUniqueId().toString())){
                            if(e.getLocation() != locationMap.get(e.getUniqueId())){
                                e.teleport(locationMap.get(e.getUniqueId().toString()));
                                Villager villager = (Villager) e;
                                villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 10));
                            }
                        }
                    }
                }
            }
        }, 200, 200);
    }
}
