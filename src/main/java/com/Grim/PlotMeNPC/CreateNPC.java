package com.Grim.PlotMeNPC;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

/**
 * Created by Harrison on 26/08/14.
 */
public class CreateNPC {

    public CreateNPC(Player player){
        FileConfiguration config = Main.plugin.getConfig();

        Villager npc = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
        UUID id = npc.getUniqueId();
        List<String> mobs;


        npc.setCustomName("§a§lPlot Manager");
        npc.setCustomNameVisible(true);
        npc.setRemoveWhenFarAway(false);
        npc.setCanPickupItems(false);
        npc.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 100));
        mobs = config.getStringList("Mobs");
        mobs.add(id.toString());
        config.set("Mobs", mobs);
        config.set(id.toString() + ".world", npc.getLocation().getWorld().getName());
        config.set(id.toString() + ".x", npc.getLocation().getX());
        config.set(id.toString() + ".y", npc.getLocation().getY());
        config.set(id.toString() + ".z", npc.getLocation().getZ());
        Main.plugin.saveConfig();
        Main.plugin.reloadConfig();
        Bukkit.getServer().getScheduler().cancelTasks(Main.plugin);
        new MobSchedule();
    }
}
