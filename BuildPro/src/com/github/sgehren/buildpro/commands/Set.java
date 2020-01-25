package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Events;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Set implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            Material customMaterial = Material.AIR;            //The material the user wants to set the blocks in the selection to

            if (s.equalsIgnoreCase("set")) {
                customMaterial = Material.matchMaterial(strings[0]);
            }

            Cuboid setBlocks = new Cuboid(Events.primarySelection, Events.secondarySelection);

            for(Block b : setBlocks) {
                b.setType(customMaterial);
            }
        }

        return false;
    }
}
