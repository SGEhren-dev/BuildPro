package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Events;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Replace implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;

            Material replaceMaterial, setMaterial;
            Cuboid cube = new Cuboid(Events.primarySelection, Events.secondarySelection);

            replaceMaterial = Material.matchMaterial(strings[0]);
            setMaterial = Material.matchMaterial(strings[1]);

            for(Block b : cube) {
                if(b.getType() == replaceMaterial) {
                    b.setType(setMaterial);
                }
            }
        }

        return false;
    }
}
