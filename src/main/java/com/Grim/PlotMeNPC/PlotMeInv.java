package com.Grim.PlotMeNPC;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Harrison on 26/08/14.
 */
public class PlotMeInv implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        if ((event.getWhoClicked() instanceof Player))
        {
            Player player = (Player) event.getWhoClicked();
            if (event.getInventory().getName().equals("PlotMeMenu"))
            {
                event.setCancelled(true);
                if (event.getCurrentItem().getType() == Material.ENDER_PEARL)
                {
                    player.performCommand("plotme auto");
                    player.closeInventory();
                }
                if (event.getCurrentItem().getType() == Material.FIREBALL)
                {
                    player.performCommand("plotme protect");
                    player.closeInventory();
                }
                if (event.getCurrentItem().getType() == Material.CHEST)
                {
                    player.performCommand("plotme biomelist");
                    player.closeInventory();
                }
                if (event.getCurrentItem().getType() == Material.PAPER)
                {
                    player.performCommand("plotme list");
                    player.closeInventory();
                }
                if (event.getCurrentItem().getType() == Material.FEATHER)
                {
                    player.performCommand("plotme clear");
                    player.closeInventory();
                }
                if (event.getCurrentItem().getType() == Material.COMPASS)
                {
                    player.performCommand("plotme help");
                    player.closeInventory();
                }
            }
        }
    }
}

