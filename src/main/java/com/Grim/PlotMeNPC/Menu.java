package com.Grim.PlotMeNPC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by Harrison on 26/08/14.
 */
public class Menu {

    public Inventory plotMe = Bukkit.createInventory(null, 9, "PlotMeMenu");

    public Menu(Player player){
        createMenu(player);
        showMenu(player);
    }

    public void createMenu(Player player){
        createDisplay(player, Material.ENDER_PEARL, plotMe ,0 , "New Plot", "Claim the next free plot");
        createDisplay(player, Material.FIREBALL, plotMe, 1, "Plot Protect", "Protect your plots");
        createDisplay(player, Material.CHEST, plotMe, 2, "Biomes", "List the available biomes");
        createDisplay(player, Material.PAPER, plotMe, 3, "Plot List", "List your current plots");
        createDisplay(player, Material.FEATHER, plotMe, 4, "Plot Clear", "Clear your plot");
        createDisplay(player, Material.COMPASS, plotMe, 8, "Plot Help", "Lists all the plot related commands");
    }

    public static void createDisplay(Player player, Material material, Inventory inv, int Slot, String name, String lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(ChatColor.GREEN + lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(Slot, item);

    }

    public void showMenu(Player player){
        player.openInventory(plotMe);
    }



}

