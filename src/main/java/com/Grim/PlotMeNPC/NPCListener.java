package com.Grim.PlotMeNPC;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created by Harrison on 26/08/14.
 */
public class NPCListener implements Listener{

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        if(entity instanceof Villager){
            Villager npc = (Villager) entity;
            if(npc.getCustomName().equals("§a§lPlot Manager")){
                event.setCancelled(true);
                new Menu(player);

            }
        }
    }

    @EventHandler
    public void onLeftClick(EntityDamageEvent event){
        Entity entity = event.getEntity();

        if(entity instanceof Villager){
            Villager npc = (Villager) entity;
            if(npc.getCustomName().equals("§a§lPlot Manager")){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDespawn(ItemDespawnEvent event){
        if (event.getEntityType() == EntityType.ARROW) {
            if(event.getEntity().getPassenger().getType() == EntityType.VILLAGER){
                event.getEntity().setTicksLived(1);
                event.setCancelled(true);
            }
        }
    }
}
