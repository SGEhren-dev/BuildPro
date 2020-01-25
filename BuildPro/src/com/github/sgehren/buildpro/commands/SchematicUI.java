package com.github.sgehren.buildpro.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SchematicUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            //create the inventory and load the schematics into the inventory to be selected for loading
        }

        return false;
    }
}
