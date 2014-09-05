package com.Grim.PlotMeNPC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Harrison on 26/08/14.
 */
public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("plotmeNPC")){
            if(!(sender instanceof Player)) return false;
            Player player = (Player) sender;
            new CreateNPC(player);

        } else if(cmd.getName().equalsIgnoreCase("plotMenu")){
            if(!(sender instanceof Player)) return false;
            Player player = (Player) sender;
            new Menu(player);

        }return false;
    }
}
